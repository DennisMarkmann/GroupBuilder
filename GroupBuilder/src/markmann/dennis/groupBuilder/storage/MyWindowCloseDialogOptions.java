package markmann.dennis.groupBuilder.storage;

public enum MyWindowCloseDialogOptions {

    REQUEST {

        @Override
        public String toString() {
            return "Do you really want to close the window?";
        }
    },

    NONE {

        @Override
        public String toString() {
            return null;
        }
    },

    WARNING {

        @Override
        public String toString() {
            return "You are closing the window.";
        }
    };
}
