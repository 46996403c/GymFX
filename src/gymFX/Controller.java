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

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
//Firebase pruebas sandra
//Firebase refw = new Firebase("https://testgimmapp.firebaseio.com/");

public class Controller {
    Empleado empleado;
    boolean equivocado = false;
    DataSnapshot snapshot1;
    boolean errorBusqueda = false;
    Alert alertError = new Alert(Alert.AlertType.ERROR);

    public WebView webView = new WebView();
    public Text Bienvenido;
    public TextField nombreCrearClienteTF;
    public TextField primerApellidoCrearClienteTF;
    public TextField segundoApellidoCrearClienteTF;
    public TextField direccionCrearCLienteTF;
    public TextField emailCrearClienteTF;
    public TextField telefonoCrearClienteTF;
    public TextField dniCrearClienteTF;
    public TextField edadCrearClienteTF;
    public TextField numSocioCrearClienteTF;
    public Button EditarDatosCliente;

    public TextField nombreVerClienteTF1;
    public TextField primerApellidoVerClienteTF1;
    public TextField segundoApellidoVerClienteTF1;
    public TextField direccionVerClienteTF1;
    public TextField emailVerClienteTF1;
    public TextField telefonoVerClienteTF1;
    public TextField dniVerClienteTF1;
    public TextField edadVerClienteTF1;
    public TextField numSocioVerClienteTF1;

    public void initialize(){
        final WebEngine webEngine = webView.getEngine();
        webEngine.load("http://bacderodasport.com");
        Bienvenido.setText("Sin Loggear");

        nombreVerClienteTF1.setEditable(false);
        primerApellidoVerClienteTF1.setEditable(false);
        segundoApellidoVerClienteTF1.setEditable(false);
        direccionVerClienteTF1.setEditable(false);
        emailVerClienteTF1.setEditable(false);
        telefonoVerClienteTF1.setEditable(false);
        edadVerClienteTF1.setEditable(false);




    }

    public void funLogin(){
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");

        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Iniciar sesion:");
        if (!equivocado){
            dialog.setHeaderText("Introduce tus credenciales:");
        } else {
            dialog.setHeaderText("Credenciales incorrectas, introducelas de nuevo:");
        }

        // Set the icon (must be included in the project).
        //dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

        // Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

        // Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Email");
        PasswordField password = new PasswordField();
        password.setPromptText("Contraseña");

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
            ref.authWithPassword(username.getText(), password.getText(), new Firebase.AuthResultHandler() {
                @Override
                public void onAuthenticated(AuthData authData) {
                    System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                    userid[0] = authData.getUid();
                    done.set(true);
                    done1.set(true);
                }

                @Override
                public void onAuthenticationError(FirebaseError firebaseError) {
                    equivocado = true;
                    done1.set(true);
                }
            });

            while (!done1.get()) ;
            if (!done.get()) {
                funLogin();
            }
        });

        if (done.get()) {
            Firebase cref = ref.child("Clientes");
            final AtomicBoolean done2 = new AtomicBoolean(false);

            Query queryRef = cref.orderByChild("uid").equalTo(userid[0]);
            queryRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                    empleado = snapshot.getValue(Empleado.class);
                    System.out.println(empleado.getNombre());
                    done2.set(true);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {}

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

                @Override
                public void onCancelled(FirebaseError firebaseError) {}
            });
            while (!done2.get());
            if (done2.get()){
                Bienvenido.setText("Bienvenido, "+ empleado.getNombre());
            }
        }
    }


    public void funCrearClie(){
        Cliente cliente = new Cliente();
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Clientes");
        Firebase.ValueResultHandler<Map<String, Object>> handler = new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Successfully created user account with uid: " + result.get("uid"));
                String a = (String) result.get("uid");
                cliente.setUID(a);
                cliente.setNombre(nombreCrearClienteTF.getText());
                cliente.setApellido(primerApellidoCrearClienteTF.getText());
                cliente.setApellido2(segundoApellidoCrearClienteTF.getText());
                cliente.setDni(dniCrearClienteTF.getText()+"4");
                cliente.setDireccion(direccionCrearCLienteTF.getText());
                cliente.setEdad(Integer.parseInt(edadCrearClienteTF.getText()));
                cliente.setEmail(emailCrearClienteTF.getText());
                cliente.setTelf(telefonoCrearClienteTF.getText());
                cliente.setnSocio(numSocioCrearClienteTF.getText());
                cref.push().setValue(cliente);
            }
            @Override
            public void onError(FirebaseError firebaseError) {
                System.out.println(firebaseError);
            }
        };
        ref.createUser(emailCrearClienteTF.getText(),"test1", handler);
    }

    public void funBuscarClie(){

        AtomicBoolean hechoBCNS = new AtomicBoolean(false);
        errorBusqueda = false;
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Clientes");
        Query queryRef = cref.orderByChild("nSocio").equalTo(numSocioVerClienteTF1.getText());
        queryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue()==null){
                    errorBusqueda = true;
                    hechoBCNS.set(true);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                snapshot1=snapshot;
                Cliente cliente = snapshot.getValue(Cliente.class);
                nombreVerClienteTF1.setText(cliente.getNombre());
                primerApellidoVerClienteTF1.setText(cliente.getApellido());
                segundoApellidoVerClienteTF1.setText(cliente.getApellido2());
                direccionVerClienteTF1.setText(cliente.getDireccion());
                emailVerClienteTF1.setText(cliente.getEmail());
                dniVerClienteTF1.setText(cliente.getDni());
                telefonoVerClienteTF1.setText(cliente.getTelf());
                edadVerClienteTF1.setText(String.valueOf(cliente.getEdad()));
                hechoBCNS.set(true);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
        while (!hechoBCNS.get());
        if (errorBusqueda){
            alertError.setTitle("Error Busqueda Num Socio");
            alertError.setHeaderText(null);
            alertError.setContentText("No hay ningun cliente con este Numero de Socio!");
            alertError.showAndWait();
        }
    }

    public void funBuscarClieDNI(){
        AtomicBoolean hechoBCDNI = new AtomicBoolean(false);
        errorBusqueda = false;
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Clientes");
        Query queryRef = cref.orderByChild("dni").equalTo(dniVerClienteTF1.getText());
        queryRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue()==null){
                    errorBusqueda = true;
                    hechoBCDNI.set(true);
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChild) {
                snapshot1=snapshot;
                Cliente cliente = snapshot.getValue(Cliente.class);
                nombreVerClienteTF1.setText(cliente.getNombre());
                primerApellidoVerClienteTF1.setText(cliente.getApellido());
                segundoApellidoVerClienteTF1.setText(cliente.getApellido2());
                direccionVerClienteTF1.setText(cliente.getDireccion());
                emailVerClienteTF1.setText(cliente.getEmail());
                telefonoVerClienteTF1.setText(cliente.getTelf());
                edadVerClienteTF1.setText(String.valueOf(cliente.getEdad()));
                numSocioVerClienteTF1.setText(cliente.getnSocio());
                hechoBCDNI.set(true);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {}

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {}

            @Override
            public void onCancelled(FirebaseError firebaseError) {}
        });
        while (!hechoBCDNI.get());
        if (errorBusqueda){
            alertError.setTitle("Error Busqueda DNI");
            alertError.setHeaderText(null);
            alertError.setContentText("No hay ningun cliente con este DNI!");
            alertError.showAndWait();
        }
    }

    public void funEditClie(){
        if (EditarDatosCliente.getText().equals("Editar datos")) {
            nombreVerClienteTF1.setEditable(true);
            primerApellidoVerClienteTF1.setEditable(true);
            segundoApellidoVerClienteTF1.setEditable(true);
            direccionVerClienteTF1.setEditable(true);
            emailVerClienteTF1.setEditable(true);
            telefonoVerClienteTF1.setEditable(true);
            edadVerClienteTF1.setEditable(true);
            EditarDatosCliente.setText("Aplicar Cambios");

        } else {
            Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
            Firebase cref = ref.child("Clientes");
            Firebase editRef = cref.child(snapshot1.getKey());
            Map<String, Object> cl = new HashMap<String, Object>();
            cl.put("apellido", primerApellidoVerClienteTF1.getText());
            cl.put("apellido2", segundoApellidoVerClienteTF1.getText());
            cl.put("nombre", primerApellidoVerClienteTF1.getText());
            cl.put("edad", edadVerClienteTF1.getText());
            cl.put("direccion", direccionVerClienteTF1.getText());
            cl.put("email", emailVerClienteTF1.getText());
            cl.put("dni", dniVerClienteTF1.getText());

            cl.put("telf", telefonoVerClienteTF1.getText());
            cl.put("apellido", primerApellidoVerClienteTF1.getText());




            editRef.updateChildren(cl);
            funBuscarClie();
            nombreVerClienteTF1.setEditable(false);
            primerApellidoVerClienteTF1.setEditable(false);
            segundoApellidoVerClienteTF1.setEditable(false);
            direccionVerClienteTF1.setEditable(false);
            emailVerClienteTF1.setEditable(false);
            telefonoVerClienteTF1.setEditable(false);
            edadVerClienteTF1.setEditable(false);
            EditarDatosCliente.setText("Editar datos");
        }
    }
}
