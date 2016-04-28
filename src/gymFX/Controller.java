package gymFX;

import com.firebase.client.*;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Pair;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class Controller {
    public WebView webView = new WebView();
    public Hyperlink hl = new Hyperlink("bacderodasport.es");
    public Text Bienvenido;
    Cliente cliente;



    public void initialize(){

        // funcion();//

        final WebEngine webEngine = webView.getEngine();

        webEngine.load("http://bacderodasport.com");

        Bienvenido.setText("Sin Loggear");


        //botonnn.setDisable(true);

    }


    public void funcion(){
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");


        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");


// Set the icon (must be included in the project).
        //     dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

// Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);
        //dialog.getDialogPane().getButtonTypes().add(loginButtonType);
        //ButtonType cancel = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {
            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();

        final AtomicBoolean done = new AtomicBoolean(false);
        final AtomicBoolean done1 = new AtomicBoolean(false);
        final String[] userid = new String[1];




        result.ifPresent(usernamePassword -> {

            ref.authWithPassword(username.getText(), "1correcthorsebatterystaple", new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                    userid[0] = authData.getUid();
                    done.set(true);
                    done1.set(true);

                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    System.out.println("s");
                    done1.set(true);
                }
            });

            while (!done1.get()) ;
            if (!done.get()) {
                System.out.println("basura");

                funcion();
            }


            // while (!done.get());
        });

        if (done.get()) {

            System.out.println("jiodhghee");

            Firebase refw = new Firebase("https://testgimmapp.firebaseio.com/");
            Firebase cref = ref.child("Clientes");


            //cref.push().setValue(cliente);

            final AtomicBoolean done2 = new AtomicBoolean(false);


            Query queryRef = cref.orderByChild("uid").equalTo(userid[0]);

            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                    cliente = snapshot.getValue(Cliente.class);
                    System.out.println(cliente.getNombre());
                    done2.set(true);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(FirebaseError firebaseError) {

                }

            });

            while (!done2.get())




                if (done2.get()){
                    System.out.println("hvuyjftty");

                    Bienvenido.setText("Bienvenido, "+cliente.getNombre());

                }


        }

    }
}
