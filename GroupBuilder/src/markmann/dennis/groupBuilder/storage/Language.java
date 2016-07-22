package markmann.dennis.groupBuilder.storage;

public enum Language {
    // TODO use to replace languagelist in pojo / language in settings.
    ENGLISH {

        @Override
        public String toString() {
            return "English";
        }
    },

    GERMAN {

        @Override
        public String toString() {
            return "German";
        }
    };

}
