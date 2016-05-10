package gymFX;

import com.firebase.client.*;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Pair;

import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collector;
//Firebase pruebas sandra
//Firebase refw = new Firebase("https://testgimmapp.firebaseio.com/");

public class Controller {
    Empleado empleado;
    boolean equivocado = false;
    DataSnapshot snapshot1;
    DataSnapshot snapshot2;
    boolean errorBusqueda = false;
    Alert alertError = new Alert(Alert.AlertType.ERROR);

    public WebView webView = new WebView();
    public Text Bienvenido;

    public Stage stage;

    //*
    public Button Button;
    //*

    public AnchorPane pane;

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

    public TextField nombreCrearEmpleadoTF;
    public TextField primerApellidoCrearEmpleadoTF;
    public TextField segundoApellidoCrearEmpleadoTF;
    public TextField direccionCrearEmpleadoTF;
    public TextField emailCrearEmpleadoTF;
    public TextField telefonoCrearEmpleadoTF;
    public TextField dniCrearEmpleadoTF;
    public TextField edadCrearEmpleadoTF;
    public TextField numEmpeladoCrearEmpleadoTF;

    public TextField nombreVerEmpleadoTF;
    public TextField primerApellidoVerEmpleadoTF;
    public TextField segundoApellidoVerEmpleadoTF;
    public TextField direccionVerEmpleadoTF;
    public TextField emailVerEmpleadoTF;
    public TextField telefonoVerEmpleadoTF;
    public TextField dniVerEmpleadoTF;
    public TextField edadVerEmpleadoTF;
    public TextField numEmpeladoVerEmpleadoTF;
    public Button EditarDatosEmpleado;

    public TextField nombreFichaPropiaTF;
    public TextField primerApellidoFichaPropiaTF;
    public TextField segundoApellidoFichaPropiaTF;
    public TextField direccionFichaPropiaTF;
    public TextField emailFichaPropiaTF;
    public TextField telefonoFichaPropiaTF;
    public TextField dniFichaPropiaTF;
    public TextField edadFichaPropiaTF;
    public TextField numEmpeladoFichaPropiaTF;

    public TextField horarioLunesViernesTF;
    public TextField horarioSabadoTF;
    public TextField horarioDomingoTF;
    public TextField nombreGymTF;
    public TextField direccionGymTF;
    public TextField telefonoGymTF;
    public TextField correoElectronicoGymTF;
    public ImageView logoInfoGymIV;
    public Button editarInfoGymBT;

    public ListView<Maquina> maquinasLV;
    public ListView<Step> pasosLV;
    public TextField idMaquinaVer;
    public TextField nombreMaquinaVer;
    public TextField FechaInstMaquinaVer;
    public TextArea descMaquinaVer;
    public TextField nStepVerStep;
    public TextField nombreStepVerStep;
    public TextField fotoStepVerStep;
    public TextArea descStepVerStep;
    public ImageView imVerS;

    public TextField idMaquinaVerIncidencia;
    public TextField tipoVerIncidencia;
    public TextArea incidenciaVerIncidencia;
    public TextField ususarioVerIncidencia;
    public TextField fechaVerIncidencia;
    public CheckBox solucionadaVerIncidencia;
    public ListView<Incidencia> incidenciasListV;
    public ListView<Incidencia> incidenciasResueltasListV;
    public TextArea comentarioIncidenciaTA;

    public TextField idmaquina;
    public TextField nombrem;
    public TextField idpaso;
    public TextField nombre;
    public TextArea descm;
    public TextArea descStep;
    public TextField linkStep;


    public Tab infoTAB;
    public Tab InicidenciasTAB;
    public Tab anadirClienteT;

    public ListView<Chat> mensajesNOleidosChatLV;
    public ListView<Chat> mensajesUsuarioChatLV;
    public TitledPane mensajesNOleidos;
    public TitledPane mensajesU;
    public TextArea mensajeChatTA;
    public TextArea respuestaChatTA;

    public MenuButton sexoCrearEmpleadoMB;
    public MenuItem maculinoCrearEmpleadoMI;
    public MenuItem femeninoCrearEmpleadoMI;


    public Maquina maquina1;
    public int step1;

    public Chat cl;
    public DataSnapshot dc;

    public Incidencia incidencia0;

    ArrayList<Step> aS = new ArrayList<Step>();


    public Button home;


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

        nombreVerEmpleadoTF.setEditable(false);
        primerApellidoVerEmpleadoTF.setEditable(false);
        segundoApellidoVerEmpleadoTF.setEditable(false);
        direccionVerEmpleadoTF.setEditable(false);
        emailVerEmpleadoTF.setEditable(false);
        telefonoVerEmpleadoTF.setEditable(false);
        edadVerEmpleadoTF.setEditable(false);


        home.setGraphic(new ImageView("http://simpleicon.com/wp-content/uploads/home-1.png"));
       // pane.getStyleClass().add("pane");

        respuestaChatTA.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    resp();
                }
            }
        });



        Firebase reff = new Firebase("https://testgimmapp.firebaseio.com/");

        Firebase creff = reff.child("Chat");




        // Attach an listener to read the data at our posts reference
        creff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                final ObservableList<Chat> items = FXCollections.observableArrayList();
                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Chat chat = postSnapshot.getValue(Chat.class);
                    if (chat.isRevisat()==false)
                        items.add(chat);

                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        mensajesNOleidosChatLV.setItems(items);
                    }
                });
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });

        mensajesNOleidosChatLV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cl = mensajesNOleidosChatLV.getFocusModel().getFocusedItem();
                mensajesNOleidos.setExpanded(false);
                mensajesU.setExpanded(true);
                mensajeChatTA.setText(cl.getMessage());
                chaat();
            }
        });

        mensajesUsuarioChatLV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cl = mensajesUsuarioChatLV.getFocusModel().getFocusedItem();

                mensajeChatTA.setText(cl.getMessage());
            }
        });






        Firebase refv = new Firebase("https://testgimmapp.firebaseio.com/");

        Firebase crefv = refv.child("Maquines");

        // Attach an listener to read the data at our posts reference
        crefv.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ObservableList<Maquina> items = FXCollections.observableArrayList();

                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Maquina maquina = postSnapshot.getValue(Maquina.class);
                    System.out.println(maquina.getDescripcio() + " - " + maquina.getNom());
                    items.add(maquina);

                }


                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            maquinasLV.setItems(items);
                        }
                    });


            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });




        maquinasLV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    Maquina m=  maquinasLV.getFocusModel().getFocusedItem();
                    System.out.println(maquinasLV.getFocusModel().getFocusedIndex());
                    ObservableList<Step> items2 = FXCollections.observableArrayList();
                    nombreMaquinaVer.setText(m.getNom());
                    descMaquinaVer.setText(m.getDescripcio());
                    idMaquinaVer.setText(m.getId());
                    descMaquinaVer.setWrapText(true);

                    FechaInstMaquinaVer.setText(m.getDataInstalacio());
                    maquina1 = m;


                    for (int i = 0; i < m.getSteps().size(); i++){
                        items2.add(m.getSteps().get(i));
                    }

                    pasosLV.setItems(items2);




                }


            }
        });

        pasosLV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount()==2){
                    Step s = pasosLV.getFocusModel().getFocusedItem();
                    nStepVerStep.setText(String.valueOf(s.getnStep()));
                    fotoStepVerStep.setText(s.getFoto());
                    nombreStepVerStep.setText(s.getAnotacio());
                    descStepVerStep.setText(s.getDescripcio());
                    descStepVerStep.setWrapText(true);
                    imVerS.setImage(new Image(s.getFoto()));
                    step1 = pasosLV.getFocusModel().getFocusedIndex();
                }

            }
        });







        incidencias();









/*

        Firebase ref3 = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref3 = ref3.child("Maquinas");
        Query queryRef3 = cref3.orderByChild("id").equalTo("s");


        queryRef3.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ms=dataSnapshot;
                Firebase editRef = cref3.child(ms.getKey());
                Map<String, Object> cl = new HashMap<String, Object>();
                cl.put("steps/0/descripcio", "h");
                editRef.updateChildren(cl);
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
*/

/*
        InfoGym infoGym = new InfoGym();


        infoGym.setIdGym(1);

        infoGym.setCorreoElectronicoGym("test@gym.es");
        infoGym.setDireccionGym("C/ falsa 465465");
        infoGym.setTelefonoGym(936569859);
        infoGym.setNombreGym("Test");
        String horario[] = new String[3];

        horario[0]="9:00 - 22:30";

        horario[1]="9:30 - 21:30";

        horario[2]="11:00 - 18:30";


        infoGym.setHorarioGym(horario);


        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");

        Firebase cref = ref.child("Infogym");

        cref.push().setValue(infoGym);
*/




        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Infogym");
        Query queryRef = cref.orderByChild("idGym").equalTo(1);
        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                InfoGym infoGym = dataSnapshot.getValue(InfoGym.class);
                snapshot2=dataSnapshot;

                horarioLunesViernesTF.setText((infoGym.getHorarioGym())[0]);
                horarioSabadoTF.setText((infoGym.getHorarioGym())[1]);
                horarioDomingoTF.setText((infoGym.getHorarioGym())[2]);
                nombreGymTF.setText(infoGym.getNombreGym());
                direccionGymTF.setText(infoGym.getDireccionGym());
                telefonoGymTF.setText(String.valueOf(infoGym.getTelefonoGym()));
                correoElectronicoGymTF.setText(infoGym.getCorreoElectronicoGym());
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


    }

    private static ImageView buildImage(String imgPatch) {
        Image i = new Image(imgPatch);
        ImageView imageView = new ImageView();
        //You can set width and height
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);
        imageView.setImage(i);
        return imageView;
    }





    public void resp() {
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref = ref.child("Chat");
        Chat chat = new Chat();
        System.out.println("shedfguy");

        Date date = new Date();
        chat.setAuthor("Centro");
        chat.setData(date.toString());
        chat.setMessage(respuestaChatTA.getText());
        chat.setUidUser(cl.getUidUser());
        chat.setRevisat(true);

        Firebase ref1 = new Firebase("https://testgimmapp.firebaseio.com/");
        cl.setRevisat(true);
        cref.push().setValue(chat);


        Firebase refd = new Firebase("https://testgimmapp.firebaseio.com/");


        Firebase crefd = refd.child("Chat");

        // Attach an listener to read the data at our posts reference
        crefd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {

                for (DataSnapshot postSnapshot : snapshot.getChildren()) {
                    Chat chat = postSnapshot.getValue(Chat.class);

                    if (chat.getUidUser().equals(cl.getUidUser())) {
                        Map<String, Object> cl1 = new HashMap<String, Object>();
                        Firebase editRef = cref.child(postSnapshot.getKey());
                        cl1.put("revisat", true);
                        editRef.updateChildren(cl1);



                    } else {
                    }

                }
                cl=null;
                respuestaChatTA.setText("");
                mensajeChatTA.setText("");


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mensajesUsuarioChatLV.setItems(null);

    }

    public void chaat(){

        System.out.println(cl.getUidUser());
        Firebase refd = new Firebase("https://testgimmapp.firebaseio.com/");



        Firebase crefd = refd.child("Chat");

        // Attach an listener to read the data at our posts reference
        crefd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                final ObservableList<Chat> items = FXCollections.observableArrayList();


                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Chat chat = postSnapshot.getValue(Chat.class);
                    if (chat.getUidUser().equals(cl.getUidUser())) {

                        items.add(chat);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                // InicidenciasTAB.setGraphic(buildImage("https://static-secure.guim.co.uk/sys-images/Guardian/Pix/pictures/2009/4/29/1240996556472/exclamation-001.jpg"));


                            }
                        });
                    }
                    else{
                        // items2.add(incidencia2);
                    }

                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        mensajesUsuarioChatLV.setItems(items);
                        //  incidenciasResueltasListV.setItems(items2);
                        // if (incidenciasListV.getItems().isEmpty()){
                        //      InicidenciasTAB.setGraphic(null);
                        //  }

                    }
                });


            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
    public void incidencias() throws IllegalStateException{
        Firebase refd = new Firebase("https://testgimmapp.firebaseio.com/");



        Firebase crefd = refd.child("Incidencias");

        // Attach an listener to read the data at our posts reference
        crefd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ObservableList<Incidencia> items = FXCollections.observableArrayList();
                ObservableList<Incidencia> items2 = FXCollections.observableArrayList();


                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Incidencia incidencia2 = postSnapshot.getValue(Incidencia.class);
                    if (!incidencia2.isRevisat()) {
                        items.add(incidencia2);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                InicidenciasTAB.setGraphic(buildImage("https://static-secure.guim.co.uk/sys-images/Guardian/Pix/pictures/2009/4/29/1240996556472/exclamation-001.jpg"));


                            }
                        });
                    }
                    else{
                        items2.add(incidencia2);
                    }

                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        incidenciasListV.setItems(items);
                        incidenciasResueltasListV.setItems(items2);
                        if (incidenciasListV.getItems().isEmpty()){
                            InicidenciasTAB.setGraphic(null);
                        }

                    }
                });


            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        incidenciasListV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    Incidencia ia=  incidenciasListV.getFocusModel().getFocusedItem();
                    ObservableList<Step> items2 = FXCollections.observableArrayList();
                    idMaquinaVerIncidencia.setText(ia.getIdMaquina());
                    ususarioVerIncidencia.setText(ia.getUser());
                    tipoVerIncidencia.setText(ia.getTipusIncidencia());
                    fechaVerIncidencia.setText(ia.getData());
                    incidenciaVerIncidencia.setText(ia.getIncidencia());
                    solucionadaVerIncidencia.setSelected(ia.isRevisat());
                    incidencia0 = ia;
                }


            }
        });

        incidenciasResueltasListV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    Incidencia ia=  incidenciasResueltasListV.getFocusModel().getFocusedItem();
                    ObservableList<Step> items2 = FXCollections.observableArrayList();
                    idMaquinaVerIncidencia.setText(ia.getIdMaquina());
                    ususarioVerIncidencia.setText(ia.getUser());
                    tipoVerIncidencia.setText(ia.getTipusIncidencia());
                    fechaVerIncidencia.setText(ia.getData());
                    incidenciaVerIncidencia.setText(ia.getIncidencia());
                    solucionadaVerIncidencia.setSelected(ia.isRevisat());
                    incidencia0 = ia;

                }


            }
        });

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
            Firebase cref = ref.child("Empleados");
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



                nombreFichaPropiaTF.setText(empleado.getNombre());
                primerApellidoFichaPropiaTF.setText(empleado.getApellido());
                segundoApellidoFichaPropiaTF.setText(empleado.getApellido2());
                direccionFichaPropiaTF.setText(empleado.getDireccion());
                emailFichaPropiaTF.setText(empleado.getEmail());
                telefonoFichaPropiaTF.setText(empleado.getTelf());
                dniFichaPropiaTF.setText(empleado.getDni());
                edadFichaPropiaTF.setText(String.valueOf(empleado.getEdad()));
                numEmpeladoFichaPropiaTF.setText(empleado.getnEmpleado());
            }
        }
    }

    public void funCrearClie(){
        Cliente cliente = new Cliente();
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
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
                cliente.setDni(dniCrearClienteTF.getText());
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
        SecureRandom SRandom = new SecureRandom();
        ref.createUser(emailCrearClienteTF.getText(),new BigInteger(32, SRandom).toString(32), handler);
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
            cl.put("nombre", nombreVerClienteTF1.getText());
            cl.put("edad", edadVerClienteTF1.getText());
            cl.put("direccion", direccionVerClienteTF1.getText());
            cl.put("email", emailVerClienteTF1.getText());
            cl.put("dni", dniVerClienteTF1.getText());
            cl.put("telf", telefonoVerClienteTF1.getText());




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

    public void funBuscarEmple(){

        AtomicBoolean hechoBCNS = new AtomicBoolean(false);
        errorBusqueda = false;
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Empleados");
        Query queryRef = cref.orderByChild("nEmpleado").equalTo(numEmpeladoVerEmpleadoTF.getText());
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
                snapshot1=snapshot;                                                                             //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
                Empleado empleado = snapshot.getValue(Empleado.class);
                nombreVerEmpleadoTF.setText(empleado.getNombre());
                primerApellidoVerEmpleadoTF.setText(empleado.getApellido());
                segundoApellidoVerEmpleadoTF.setText(empleado.getApellido2());
                direccionVerEmpleadoTF.setText(empleado.getDireccion());
                emailVerEmpleadoTF.setText(empleado.getEmail());
                dniVerEmpleadoTF.setText(empleado.getDni());
                telefonoVerEmpleadoTF.setText(empleado.getTelf());
                edadVerEmpleadoTF.setText(String.valueOf(empleado.getEdad()));
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
            alertError.setTitle("Error Busqueda Num Empleado");
            alertError.setHeaderText(null);
            alertError.setContentText("No hay ningun empleado con este Numero de Empleado!");
            alertError.showAndWait();
        }
    }

    public void funBuscarEmpleDNI(){
        AtomicBoolean hechoBCDNI = new AtomicBoolean(false);
        errorBusqueda = false;
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Empleados");
        Query queryRef = cref.orderByChild("dni").equalTo(dniVerEmpleadoTF.getText());
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
                Empleado empleado = snapshot.getValue(Empleado.class);
                nombreVerEmpleadoTF.setText(empleado.getNombre());
                primerApellidoVerEmpleadoTF.setText(empleado.getApellido());
                segundoApellidoVerEmpleadoTF.setText(empleado.getApellido2());
                direccionVerEmpleadoTF.setText(empleado.getDireccion());
                emailVerEmpleadoTF.setText(empleado.getEmail());
                telefonoVerEmpleadoTF.setText(empleado.getTelf());
                edadVerEmpleadoTF.setText(String.valueOf(empleado.getEdad()));
                numEmpeladoVerEmpleadoTF.setText(empleado.getnEmpleado());
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
            alertError.setContentText("No hay ningun Empleado con este DNI!");
            alertError.showAndWait();
        }
    }

    public void funCrearEmple() {
        Empleado empleado = new Empleado();
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Empleados");
        Firebase.ValueResultHandler<Map<String, Object>> handler = new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                System.out.println("Successfully created user account with uid: " + result.get("uid"));
                String a = (String) result.get("uid");
                empleado.setUID(a);
                empleado.setNombre(nombreCrearEmpleadoTF.getText());
                empleado.setApellido(primerApellidoCrearEmpleadoTF.getText());
                empleado.setApellido2(segundoApellidoCrearEmpleadoTF.getText());
                empleado.setDni(dniCrearEmpleadoTF.getText());
                empleado.setDireccion(direccionCrearEmpleadoTF.getText());
                empleado.setEdad(Integer.parseInt(edadCrearEmpleadoTF.getText()));
                empleado.setEmail(emailCrearEmpleadoTF.getText());
                empleado.setTelf(telefonoCrearEmpleadoTF.getText());
                empleado.setnEmpleado(numEmpeladoCrearEmpleadoTF.getText());
                empleado.setSexo("");
                cref.push().setValue(empleado);
            }
            @Override
            public void onError(FirebaseError firebaseError) {
                System.out.println(firebaseError);
            }
        };
        SecureRandom SRandom = new SecureRandom();
        ref.createUser(emailCrearEmpleadoTF.getText(),new BigInteger(32, SRandom).toString(32), handler);



    }

    public void funEditEmple(){
        if (EditarDatosEmpleado.getText().equals("Editar datos")) {
            nombreVerEmpleadoTF.setEditable(true);
            primerApellidoVerEmpleadoTF.setEditable(true);
            segundoApellidoVerEmpleadoTF.setEditable(true);
            direccionVerEmpleadoTF.setEditable(true);
            emailVerEmpleadoTF.setEditable(true);
            telefonoVerEmpleadoTF.setEditable(true);
            edadVerEmpleadoTF.setEditable(true);
            EditarDatosEmpleado.setText("Aplicar Cambios");

        } else {
            Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
            Firebase cref = ref.child("Empleados");
            Firebase editRef = cref.child(snapshot1.getKey());
            Map<String, Object> cl = new HashMap<String, Object>();
            cl.put("apellido", primerApellidoVerEmpleadoTF.getText());
            cl.put("apellido2", segundoApellidoVerEmpleadoTF.getText());
            cl.put("nombre", nombreVerEmpleadoTF.getText());
            cl.put("edad", edadVerEmpleadoTF.getText());
            cl.put("direccion", direccionVerEmpleadoTF.getText());
            cl.put("email", emailVerEmpleadoTF.getText());
            cl.put("dni", dniVerEmpleadoTF.getText());
            cl.put("telf", telefonoVerEmpleadoTF.getText());




            editRef.updateChildren(cl);
            funBuscarEmple();
            nombreVerEmpleadoTF.setEditable(false);
            primerApellidoVerEmpleadoTF.setEditable(false);
            segundoApellidoVerEmpleadoTF.setEditable(false);
            direccionVerEmpleadoTF.setEditable(false);
            emailVerEmpleadoTF.setEditable(false);
            telefonoVerEmpleadoTF.setEditable(false);
            edadVerEmpleadoTF.setEditable(false);
            EditarDatosEmpleado.setText("Editar datos");
        }
    }

    public void funEditGym(){
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Infogym");
        Firebase editRef = cref.child(snapshot2.getKey());
        Map<String, Object> cl = new HashMap<String, Object>();
        cl.put("telefonoGym", telefonoGymTF.getText());
        cl.put("nombreGym", nombreGymTF.getText());
        cl.put("direccionGym", direccionGymTF.getText());
        cl.put("correoElectronicoGym", correoElectronicoGymTF.getText());
        cl.put("horarioGym/0", horarioLunesViernesTF.getText());
        cl.put("horarioGym/0", horarioLunesViernesTF.getText());
        cl.put("horarioGym/0", horarioLunesViernesTF.getText());

        editRef.updateChildren(cl);

    }

    public void funEditMaq(){

        Firebase ref3 = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref3 = ref3.child("Maquines");
        Query queryRef3 = cref3.orderByChild("id").equalTo(maquina1.getId());
        queryRef3.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Firebase editRef = cref3.child(dataSnapshot.getKey());
                Map<String, Object> cl = new HashMap<String, Object>();
                cl.put("descripcio", descMaquinaVer.getText());
                cl.put("nom", nombreMaquinaVer.getText());
                cl.put("dataInstalacio", FechaInstMaquinaVer.getText());
                editRef.updateChildren(cl);
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

    }

    public void funEditSt(){

        Firebase ref3 = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref3 = ref3.child("Maquines");
        Query queryRef3 = cref3.orderByChild("id").equalTo(maquina1.getId());
        queryRef3.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Firebase editRef = cref3.child(dataSnapshot.getKey());
                Map<String, Object> cl = new HashMap<String, Object>();
                cl.put("steps/"+step1+"/descripcio", "h");
                editRef.updateChildren(cl);
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



    }








    public void funGuardarPaso(){

       // Maquina maquina = new Maquina();
        Step step = new Step();




       // ArrayList<Step> aS = new ArrayList<Step>();

        step.setnStep(Integer.parseInt(idpaso.getText()));
        step.setDescripcio(descStep.getText());
        step.setAnotacio(nombre.getText());
        step.setFoto(linkStep.getText());

        aS.add(step);

    }


    public void funGuardarMaquina(){
        Maquina maquina = new Maquina();

        Date date = new Date();
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");

        Firebase cref = ref.child("Maquinas");
        maquina.setNom(nombrem.getText());
        maquina.setDescripcio(descm.getText());
        maquina.setId(idmaquina.getText());
        maquina.setDataInstalacio(date.toString());


        maquina.setSteps(aS);

        cref.push().setValue(maquina);

        aS.clear();

    }

    public void funSolInc(){
        Firebase ref3 = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref3 = ref3.child("Incidencias");
        Query queryRef3 = cref3.orderByChild("id").equalTo(incidencia0.getId());

        queryRef3.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Firebase editRef = cref3.child(dataSnapshot.getKey());
                Map<String, Object> cl = new HashMap<String, Object>();
                cl.put("revisat", true);
                cl.put("coment", comentarioIncidenciaTA.getText());
                editRef.updateChildren(cl);
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


    }

    public void abrirRespuesta() throws Exception {
        FileChooser abrirArchivo = new FileChooser();
        extnsionesArchivos(abrirArchivo);
        abrirArchivo.setTitle("Abrir archivo...");

        File archivoAbierto = abrirArchivo.showOpenDialog(stage);
        FileReader archivoEditar = new FileReader(archivoAbierto);
        BufferedReader BrArchivo =  new BufferedReader(archivoEditar);

        String textoDoc;
        while((textoDoc = BrArchivo.readLine())!=null) {
            comentarioIncidenciaTA.setText(comentarioIncidenciaTA.getText()+"\n"+textoDoc);
        }
        BrArchivo.close();
    }
    public void guardarRespuesta() throws IOException {
        FileChooser guardarArchivo = new FileChooser();
        extnsionesArchivos(guardarArchivo);
        guardarArchivo.setTitle("Guardar archivo como...");

        File archivoGuardado = guardarArchivo.showSaveDialog(stage);
        FileWriter archivoEditado = new FileWriter(archivoGuardado);
        BufferedWriter BwArchivo = new BufferedWriter(archivoEditado);
        String docTexto = comentarioIncidenciaTA.getText();
        BwArchivo.write(docTexto);
        BwArchivo.close();
    }
    private static void extnsionesArchivos(final FileChooser escojerArchivo) {
        escojerArchivo.setInitialDirectory(new File(System.getProperty("user.home")));
        escojerArchivo.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos", "*.*"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("NFO", "*.nfo")
        );
    }


    public void funBorrarC(){
        Firebase ref = new Firebase("https://fiery-inferno-9835.firebaseio.com/");
        Firebase cref = ref.child("Clientes");

        Query queryRef = cref.orderByChild("nombre").equalTo(nombreVerClienteTF1.getText());

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String g = dataSnapshot.getKey();


                Cliente cliente = dataSnapshot.getValue(Cliente.class);
                Firebase firebase = new Firebase("https://fiery-inferno-9835.firebaseio.com/Clientes/"+g);
                firebase.removeValue();
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
    }
    public void selectMasc(){
        if (sexoCrearEmpleadoMB.isFocused())
        sexoCrearEmpleadoMB.setText("Masculino");
    }

    public void selectFeme(){
        sexoCrearEmpleadoMB.setText("Femenino");
    }

    public void home(){
        webView.getEngine().load("http://bacderodasport.com");
    }

}
// PASOS