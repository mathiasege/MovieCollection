public enum MovieSearchCriteria {
    TITLE("TITLE"),
    DIRECTOR("DIRECTOR"),
    YEAR_CREATED("YEAR"),
    IS_IN_COLOR("COLOR"),
    LENGTH("LENGTH"),
    GENRE("GENRE");

    final String keyword;

    MovieSearchCriteria(String keyword){
        this.keyword = keyword;
    }
}
