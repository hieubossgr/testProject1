public class FileModel {
    private String url;
    private int lengOfCharacterOfLine;
    private boolean lengOfCharacter;

    FileModel() {
        lengOfCharacterOfLine = 256;
        lengOfCharacter = true;
    }

    FileModel(String url) {
        this.url = url;
        lengOfCharacter = true;
        lengOfCharacterOfLine = 256;
    }

    public boolean isLengOfCharacter() {
        return lengOfCharacter;
    }

    public void setLengOfCharacter(boolean lengOfCharacter) {
        this.lengOfCharacter = lengOfCharacter;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getLengOfCharacterOfLine() {
        return lengOfCharacterOfLine;
    }

    public void setLengOfCharacterOfLine(int lengOfCharacterOfLine) {
        this.lengOfCharacterOfLine = lengOfCharacterOfLine;
    }
}
