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

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collector;

public class Controller {
    Empleado empleado;
    boolean equivocado = false;
    DataSnapshot snapshot1;
    DataSnapshot snapshot2;
    boolean errorBusqueda = false;
    Alert alertError = new Alert(Alert.AlertType.ERROR);
    Alert alert = new Alert(Alert.AlertType.INFORMATION);

    public WebView webView = new WebView();
    public Text Bienvenido;

    public Stage stage;

    //public AnchorPane pane;

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
    public TextField categoria;
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
    public Tab IniTAB;
    public Tab clienteTAB;
    public Tab empleadoTAB;
    public Tab maquinasTAB;

    public Tab ChatTAB1;

    public ListView<Chat> mensajesNOleidosChatLV;
    public ListView<Chat> mensajesUsuarioChatLV;
    public TitledPane mensajesNOleidos;
    public TitledPane mensajesU;
    public TextArea mensajeChatTA;
    public TextArea respuestaChatTA;

    public MenuButton sexoCrearEmpleadoMB;
    public MenuItem maculinoCrearEmpleadoMI;
    public MenuItem femeninoCrearEmpleadoMI;
    public MenuButton sexoVerClienteTF1;
    public MenuItem maculinoVerClienteMI;
    public MenuItem        femeninoVerClienteMI;
    public MenuButton sexoVerEmpleadoTF;
    public MenuButton sexoCrearClienteMB;
    public Button cerrarIncidenciaBT;

    public Maquina maquina1;
    public int step1;

    public Chat cl;
    public DataSnapshot dc;

    public Incidencia incidencia0;

    ArrayList<Step> aS = new ArrayList<>();

    public Button home;

    public void initialize(){


        final WebEngine webEngine = webView.getEngine();
        webEngine.load("http://bacderodasport.com");
        Bienvenido.setText("Sin Logear");

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

        infoTAB.setDisable(false);
        InicidenciasTAB.setDisable(true);
        anadirClienteT.setDisable(true);
        IniTAB.setDisable(false);
        clienteTAB.setDisable(true);
        empleadoTAB.setDisable(true);
        maquinasTAB.setDisable(true);
        ChatTAB1.setDisable(true);


        IniTAB.setGraphic(buildImage("http://i63.tinypic.com/2vwbd50.png"));
        clienteTAB.setGraphic(buildImage("http://i64.tinypic.com/1ftxch.png"));
        empleadoTAB.setGraphic(buildImage("http://i67.tinypic.com/14wzoxs.png"));
        maquinasTAB.setGraphic(buildImage("http://i67.tinypic.com/r9iwdi.png"));
        InicidenciasTAB.setGraphic(buildImage("http://i63.tinypic.com/1oau4l.png"));
        ChatTAB1.setGraphic(buildImage("http://i67.tinypic.com/20f3g4l.png"));

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
                        if (!mensajesNOleidosChatLV.getItems().isEmpty()){
                            ChatTAB1.setGraphic(buildImage("http://i64.tinypic.com/2i067tw.png"));
                        }
                        else{
                            ChatTAB1.setGraphic(buildImage("http://i67.tinypic.com/20f3g4l.png"));

                        }
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

        maquinas();
        incidencias();

        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref = ref.child("InfoGym");
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

    /**
     * Metodo para rellenar las maquinas
     */
    public void maquinas(){
        Firebase refv = new Firebase("https://testgimmapp.firebaseio.com/");

        Firebase crefv = refv.child("Maquines");

        // Attach an listener to read the data at our posts reference
        crefv.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ObservableList<Maquina> items = FXCollections.observableArrayList();

                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Maquina maquina = postSnapshot.getValue(Maquina.class);
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
                    try {


                        imVerS.setImage(new Image(s.getFoto()));
                    }catch (Exception e){
                        imVerS.setImage(null);
                    }

                    step1 = pasosLV.getFocusModel().getFocusedIndex();
                }

            }
        });
    }

    /*
     * Metodo para crear una imagen de ImageView
     */
    private static ImageView buildImage(String imgPatch) {
        Image i = new Image(imgPatch);
        ImageView imageView = new ImageView();
        //You can set width and height
        imageView.setFitHeight(16);
        imageView.setFitWidth(16);
        imageView.setImage(i);
        return imageView;
    }

    /*
    * Metodo para rellenar el chat
     */
    public void chaat(){

        Firebase refd = new Firebase("https://testgimmapp.firebaseio.com/");

        Firebase crefd = refd.child("Chat");

        // Attach an listener to read the data at our posts reference
        crefd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                final ObservableList<Chat> items = FXCollections.observableArrayList();

                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Chat chat = postSnapshot.getValue(Chat.class);
                    try {
                        if (chat.getUidUser().equals(cl.getUidUser())) {

                            items.add(chat);

                        }
                    }catch (Exception d){

                    }

                }

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        mensajesUsuarioChatLV.setItems(items);
                    }
                });


            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }

    /*
       * Metodo usado para dar respuesta al chat
       */
    public void resp() {
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref = ref.child("Chat");
        Chat chat = new Chat();

        Date date = new Date();
        chat.setAuthor("Centro");
        chat.setData(date.toString());
        chat.setMessage(respuestaChatTA.getText());
        chat.setUidUser(cl.getUidUser());
        chat.setRevisat(true);

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
                        Map<String, Object> cl1 = new HashMap<>();
                        Firebase editRef = cref.child(postSnapshot.getKey());
                        cl1.put("revisat", true);
                        editRef.updateChildren(cl1);


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

    /*
     * Metodo para rellenar las incidencias
     */
    public void incidencias() throws IllegalStateException{
        Firebase refd = new Firebase("https://testgimmapp.firebaseio.com/");

        Firebase crefd = refd.child("Incidencias");

        // Attach an listener to read the data at our posts reference
        crefd.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                ObservableList<Incidencia> items = FXCollections.observableArrayList();
                ObservableList<Incidencia> items2 = FXCollections.observableArrayList();

                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    Incidencia incidencia2 = postSnapshot.getValue(Incidencia.class);
                    if (!incidencia2.isRevisat()) {
                        items.add(incidencia2);
                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                InicidenciasTAB.setGraphic(buildImage("http://i65.tinypic.com/339jexi.png"));

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
                            InicidenciasTAB.setGraphic(buildImage("http://i66.tinypic.com/20zdxzs.png"));
                        }

                    }
                });

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
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
                    comentarioIncidenciaTA.setText("");
                    cerrarIncidenciaBT.setDisable(false);
                    incidencia0 = ia;
                }


            }
        });

        incidenciasResueltasListV.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2){
                    Incidencia ia=  incidenciasResueltasListV.getFocusModel().getFocusedItem();
                    idMaquinaVerIncidencia.setText(ia.getIdMaquina());
                    ususarioVerIncidencia.setText(ia.getUser());
                    tipoVerIncidencia.setText(ia.getTipusIncidencia());
                    fechaVerIncidencia.setText(ia.getData());
                    incidenciaVerIncidencia.setText(ia.getIncidencia());
                    solucionadaVerIncidencia.setSelected(ia.isRevisat());
                    comentarioIncidenciaTA.setText("");
                    cerrarIncidenciaBT.setDisable(true);

                    incidencia0 = ia;

                }


            }
        });

    }

    /*
     * Metodo para login
     */
    public void funLogin(){
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");

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
                setPerm(empleado.getCat());

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


    /*
     * Metodo para asignar poermisos
     */
    public void setPerm(int a){
        if (a==1){
            infoTAB.setDisable(false);
            InicidenciasTAB.setDisable(false);
            anadirClienteT.setDisable(false);
            IniTAB.setDisable(false);
            clienteTAB.setDisable(false);
            empleadoTAB.setDisable(false);
            maquinasTAB.setDisable(true);
            ChatTAB1.setDisable(false);

            //logoInfoGymIV;
        }
        if (a==2){
            infoTAB.setDisable(false);
            InicidenciasTAB.setDisable(false);
            anadirClienteT.setDisable(false);
            IniTAB.setDisable(false);
            clienteTAB.setDisable(false);
            empleadoTAB.setDisable(false);
            maquinasTAB.setDisable(false);
            ChatTAB1.setDisable(false);
            horarioLunesViernesTF.setEditable(true);
            horarioSabadoTF.setEditable(true);
            horarioDomingoTF.setEditable(true);
            nombreGymTF.setEditable(true);
            direccionGymTF.setEditable(true);
            telefonoGymTF.setEditable(true);
            correoElectronicoGymTF.setEditable(true);
        }

    }

    /*
     * Metodo para crear socio
     */
    public void funCrearClie(){
        Cliente cliente = new Cliente();
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref = ref.child("Clientes");
        Boolean cr=null;
        Firebase.ValueResultHandler<Map<String, Object>> handler = new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
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
                cliente.setSexo(sexoCrearClienteMB.getText());
                cref.push().setValue(cliente);
                alert.setTitle("Socio Creado");
                alert.setHeaderText(null);
                alert.setContentText("Socio creado de forma correcta.");
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        alert.showAndWait();

                    }

                });
            }
            @Override
            public void onError(FirebaseError firebaseError) {
                alertError.setTitle("Error");
                alertError.setContentText("Error en la creacion de socio");
                System.out.println(firebaseError);
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        alertError.showAndWait();
                    }});
            }
        };
        SecureRandom SRandom = new SecureRandom();
        String pass = new BigInteger(32, SRandom).toString(32);
        ref.createUser(emailCrearClienteTF.getText(),pass, handler);
        enviarEmailPass(emailCrearClienteTF.getText(), pass);
        alert.setTitle("Socio Creado");
        alert.setHeaderText(null);
        alert.setContentText("Socio creado de forma correcta.");
        alert.showAndWait();
    }

    /*
     * Metodo para bsucar socio
     */
    public void funBuscarClie(){

        AtomicBoolean hechoBCNS = new AtomicBoolean(false);
        errorBusqueda = false;
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
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
                Platform.runLater(new Runnable() {
                                      @Override
                                      public void run() {
                                          sexoVerClienteTF1.setText(cliente.getSexo());
                                      }
                                  });
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

    /*
     * Metodo que busca socio por DNI
     */
    public void funBuscarClieDNI(){
        AtomicBoolean hechoBCDNI = new AtomicBoolean(false);
        errorBusqueda = false;
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
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
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        sexoVerClienteTF1.setText(cliente.getSexo());
                    }});
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

    /*
     * Metodo pàra editar socio
     */
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
            Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
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
            cl.put("sexo", sexoVerClienteTF1.getText());

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

    /*
     *Funcion para buscar Empleados
     */
    public void funBuscarEmple(){

        AtomicBoolean hechoBCNS = new AtomicBoolean(false);
        errorBusqueda = false;
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
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
                try {
                    Empleado empleado = snapshot.getValue(Empleado.class);
                    nombreVerEmpleadoTF.setText(empleado.getNombre());
                    primerApellidoVerEmpleadoTF.setText(empleado.getApellido());
                    segundoApellidoVerEmpleadoTF.setText(empleado.getApellido2());
                    direccionVerEmpleadoTF.setText(empleado.getDireccion());
                    emailVerEmpleadoTF.setText(empleado.getEmail());
                    dniVerEmpleadoTF.setText(empleado.getDni());
                    telefonoVerEmpleadoTF.setText(empleado.getTelf());
                    edadVerEmpleadoTF.setText(String.valueOf(empleado.getEdad()));
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            sexoVerEmpleadoTF.setText(empleado.getSexo());
                        }});
                    hechoBCNS.set(true);
                }catch (Exception e){

                }

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

/*
 * Funcion para buscar empleado por DNI
 */
    public void funBuscarEmpleDNI(){
        AtomicBoolean hechoBCDNI = new AtomicBoolean(false);
        errorBusqueda = false;
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
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
                Platform.runLater(new Runnable() {
                                      @Override
                                      public void run(){

                                      sexoVerEmpleadoTF.setText(empleado.getSexo());
                                  }});
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

    /*
     * Funcion para crear EMpleado
     */
    public void funCrearEmple() {
        Empleado empleado1 = new Empleado();
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref = ref.child("Empleados");
        AtomicBoolean crear = null;
        Firebase.ValueResultHandler<Map<String, Object>> handler = new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                String a = (String) result.get("uid");
                empleado1.setUID(a);
                empleado1.setNombre(nombreCrearEmpleadoTF.getText());
                empleado1.setApellido(primerApellidoCrearEmpleadoTF.getText());
                empleado1.setApellido2(segundoApellidoCrearEmpleadoTF.getText());
                empleado1.setDni(dniCrearEmpleadoTF.getText());
                empleado1.setDireccion(direccionCrearEmpleadoTF.getText());
                empleado1.setEdad(Integer.parseInt(edadCrearEmpleadoTF.getText()));
                empleado1.setEmail(emailCrearEmpleadoTF.getText());
                empleado1.setTelf(telefonoCrearEmpleadoTF.getText());
                empleado1.setnEmpleado(numEmpeladoCrearEmpleadoTF.getText());
                empleado1.setSexo(sexoCrearEmpleadoMB.getText());
                if (empleado.getCat() == 1) {
                    categoria.setText("1");
                }
                empleado1.setCat(Integer.parseInt(categoria.getText()));


                cref.push().setValue(empleado1);

            }

            @Override
            public void onError(FirebaseError firebaseError) {
                alertError.setTitle("Error!");
                alertError.setContentText("Error al crear empleado");
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        alertError.showAndWait();

                    }


                });
            }
        };




            SecureRandom SRandom = new SecureRandom();
            String pass = new BigInteger(32, SRandom).toString(32);
            ref.createUser(emailCrearEmpleadoTF.getText(), pass, handler);
            enviarEmailPass(emailCrearEmpleadoTF.getText(), pass);



    }

    /*
     * Funcion para editar empleado
     */
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
            Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
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
            cl.put("sexo", sexoVerEmpleadoTF.getText());


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


    /**
     * Funcion para enviar mail registro
     * @param Destinatario
     * @param pass
     */
    public static void enviarEmailPass(String Destinatario, String pass){
        String cuerpoMensaje = "Tu contraseña es la siguiente: "+pass+"\nSi tienes algun problema ponte en contacto con el administrador del centro.";
        String asuntoMensaje = "Cuenta creada";

        //usuario del servidor
        final String usernameServer = "gym.app.enjoy@gmail.com";

        //Contraseña servidor
        final String passwordServer = "oscareselputoamo";

        //Host servidor
        String host = "smtp.gmail.com";

        //Propiedades servidor
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object.
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usernameServer, passwordServer);
            }
        });

        // Sender's email ID needs to be mentioned
        //Correo origen
        String from = "gym.app.enjoy@gmail.com";

        // Recipient's email ID needs to be mentioned.
        //Correo destino
        String to = Destinatario; //---------------------> Pillar campo de texto del correo.

        try {
            // Create a default MimeMessage object.
            Message message = new MimeMessage(session);

            // Set From: header field of the header.
            message.setFrom(new InternetAddress(from));

            // Set To: header field of the header.
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));

            // Set Subject: header field
            message.setSubject(asuntoMensaje);

            // Now set the actual message
            message.setText(cuerpoMensaje);

            // Send message
            Transport.send(message);


        } catch (MessagingException e) {

        }
    }

    /*
    * Funcion para editar gimansio
     */
    public void funEditGym(){
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref = ref.child("InfoGym");
        Firebase editRef = cref.child(snapshot2.getKey());
        Map<String, Object> cl = new HashMap<String, Object>();
        cl.put("telefonoGym", telefonoGymTF.getText());
        cl.put("nombreGym", nombreGymTF.getText());
        cl.put("direccionGym", direccionGymTF.getText());
        cl.put("correoElectronicoGym", correoElectronicoGymTF.getText());
        cl.put("horarioGym/0", horarioLunesViernesTF.getText());
        cl.put("horarioGym/1", horarioSabadoTF.getText());
        cl.put("horarioGym/2", horarioDomingoTF.getText());

        editRef.updateChildren(cl);

    }

    /*
     * Funcion para editar maquina
     */
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
                maquinas();

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

    /*
     * Funcion para editar step .
     */
    public void funEditSt(){

        Firebase ref3 = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref3 = ref3.child("Maquines");
        Query queryRef3 = cref3.orderByChild("id").equalTo(maquina1.getId());
        queryRef3.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Firebase editRef = cref3.child(dataSnapshot.getKey());
                Map<String, Object> cl = new HashMap<String, Object>();
                cl.put("steps/"+step1+"/descripcio",descStepVerStep.getText());
                cl.put("steps/"+step1+"/anotacio", nombreStepVerStep.getText());
                cl.put("steps/"+step1+"/foto", fotoStepVerStep.getText());
                cl.put("steps/"+step1+"/nStep", nStepVerStep.getText());
                editRef.updateChildren(cl);
                maquinas();
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


    /*
     * Funcion de creacion de maquina que gusrda el paso
     */
    public void funGuardarPaso(){

        Step step = new Step();

        step.setnStep(Integer.parseInt(idpaso.getText()));
        step.setDescripcio(descStep.getText());
        step.setAnotacio(nombre.getText());
        step.setFoto(linkStep.getText());

        aS.add(step);

        alert.setTitle("Paso añadido");
        alert.setHeaderText("");
        alert.setContentText("El paso ha sido añadido");
        alert.showAndWait();

    }


    /*
     * Funcion para huardar  maquina
     */
    public void funGuardarMaquina(){
        Maquina maquina = new Maquina();

        Date date = new Date();
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");

        Firebase cref = ref.child("Maquines");
        maquina.setNom(nombrem.getText());
        maquina.setDescripcio(descm.getText());
        maquina.setId(idmaquina.getText());
        maquina.setDataInstalacio(date.toString());

        maquina.setSteps(aS);

        cref.push().setValue(maquina);

        aS.clear();

    }

    /*
     * Funcion de solucion de inicidencia
     */
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

    /*
     * Actualizar imagenb de step
     */
    public void actuImagen1()
    {
        imVerS.setImage(new Image(fotoStepVerStep.getText()));
    }


    /*
     * Funcion que abre respuesta predefinida
     */
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

    /*
     * Guardar respuesta predefinida
     */
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

    /*
     * Funcion de apoyo
     */
    private static void extnsionesArchivos(final FileChooser escojerArchivo) {
        escojerArchivo.setInitialDirectory(new File(System.getProperty("user.home")));
        escojerArchivo.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Todos", "*.*"),
                new FileChooser.ExtensionFilter("TXT", "*.txt"),
                new FileChooser.ExtensionFilter("NFO", "*.nfo")
        );
    }


    /*
     * MEtodo de borrar cliente
     */
    public void funBorrarC(){
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref = ref.child("Clientes");

        Query queryRef = cref.orderByChild("nSocio").equalTo(numSocioVerClienteTF1.getText());

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String g = dataSnapshot.getKey();
                Platform.runLater(new Runnable() {
                                      @Override
                                      public void run() {
                                          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                          alert.setTitle("Confirmación Eliminar");
                                          alert.setContentText("Estas seguro de querer eliminar a este cliente?");

                                          alert.showAndWait();
                                          //System.out.println(b[0]);
                                          if (alert.getResult().equals(ButtonType.CANCEL)){

                                          }
                                          else {
                                              Firebase firebase = new Firebase("https://testgimmapp.firebaseio.com/Clientes/" + g);
                                              firebase.removeValue();

                                          }
                                      }
                                  });







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

    /*
     * MEtodo de borrar empleado
     */
    public void funBorrarE(){
        Firebase ref = new Firebase("https://testgimmapp.firebaseio.com/");
        Firebase cref = ref.child("Empleados");

        Query queryRef = cref.orderByChild("nEmpleado").equalTo(numEmpeladoVerEmpleadoTF.getText());

        queryRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                String g = dataSnapshot.getKey();
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirmación Eliminar");
                        alert.setContentText("Estas seguro de querer eliminar a este empleado?");

                        alert.showAndWait();
                        //System.out.println(b[0]);
                        if (alert.getResult().equals(ButtonType.CANCEL)){

                        }
                        else {
                            Firebase firebase = new Firebase("https://testgimmapp.firebaseio.com/Empleados/"+g);
                            firebase.removeValue();

                        }
                    }
                });

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


    /*
     * Metodos para escriubir en el MB el sexo clickado
     */
    public void selectMasc(){
        if (sexoCrearEmpleadoMB.isFocused())
            sexoCrearEmpleadoMB.setText("Masculino");
        if (sexoVerClienteTF1.isFocused())
            sexoVerClienteTF1.setText("Masculino");
        if (sexoVerEmpleadoTF.isFocused())
            sexoVerEmpleadoTF.setText("Masculino");
        if (sexoCrearClienteMB.isFocused())
            sexoCrearClienteMB.setText("Masculino");



    }

    public void selectFeme(){
        if (sexoCrearEmpleadoMB.isFocused())
            sexoCrearEmpleadoMB.setText("Femenino");
        if (sexoVerClienteTF1.isFocused())
            sexoVerClienteTF1.setText("Femeniino");
        if (sexoVerEmpleadoTF.isFocused())
            sexoVerEmpleadoTF.setText("Femenino");
        if (sexoCrearClienteMB.isFocused())
            sexoCrearClienteMB.setText("Femenino");
    }

    /*
     * Metodo de home del webBrowser
     */
    public void home(){
        webView.getEngine().load("http://bacderodasport.com");
    }

    public void logOut(){

        Bienvenido.setText("Sin Logear");
        horarioLunesViernesTF.setEditable(false);
        horarioSabadoTF.setEditable(false);
        horarioDomingoTF.setEditable(false);
        nombreGymTF.setEditable(false);
        direccionGymTF.setEditable(false);
        telefonoGymTF.setEditable(false);
        correoElectronicoGymTF.setEditable(false);

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

        infoTAB.setDisable(false);
        InicidenciasTAB.setDisable(true);
        anadirClienteT.setDisable(true);
        IniTAB.setDisable(false);
        clienteTAB.setDisable(true);
        empleadoTAB.setDisable(true);
        maquinasTAB.setDisable(true);
        ChatTAB1.setDisable(true);
    }

}
