public class Criteria {

    private String folder_path;
    private boolean includeSubFolder;
    private String extension;

    public Criteria(String folder_path, String extension, boolean includeSubFolder) {
        this.folder_path = folder_path;
        this.extension = extension;
        this.includeSubFolder = includeSubFolder;
    }

    public String getFolder_path() {
        return folder_path;
    }

    public void setFolder_path(String folder_path) {
        this.folder_path = folder_path;
    }

    public boolean isIncludeSubFolder() {
        return includeSubFolder;
    }

    public void setIncludeSubFolder(boolean includeSubFolder) {
        this.includeSubFolder = includeSubFolder;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }
}
