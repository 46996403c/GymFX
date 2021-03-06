package gymFX;

/**
 * Created by 47993849w on 06/05/16.
 */
public class Chat {


        private String message;
        private String author;
        private String uidUser;
        private boolean revisat;
        private String data;


    //ID!!!!!!!!!!!

        // Required default constructor for Firebase object mapping
        @SuppressWarnings("unused")
        public Chat() {
        }

        public Chat(String message, String author, String uidUser) {
            this.message = message;
            this.author = author;
            this.uidUser = uidUser;
        }

        public String getMessage() {
            return message;
        }

        public String getAuthor() {
            return author;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getUidUser() {
            return uidUser;
        }

        public void setUidUser(String uidUser) {
            this.uidUser = uidUser;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public boolean isRevisat() {
            return revisat;
        }

        public void setRevisat(boolean revisat) {
            this.revisat = revisat;
        }

    public String toString(){
        try {
            return ("[" + getAuthor() + "] " + getMessage().substring(0, 15) + "...");
        }catch (Exception e){
            return ("[" + getAuthor() + "] " + getMessage());
        }
    }

}
