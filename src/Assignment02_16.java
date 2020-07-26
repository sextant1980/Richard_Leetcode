import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Assignment02_16 {

    static int countFile = 0;
    static int countFolder = 0;

    public static void main(String[] args) {

        System.out.println("Please input a path:");
        Scanner path = new Scanner(System.in).useDelimiter("\n");
        String extension = "mp4";
        boolean includeSubFolder = true;
        String main_path_str = path.next();

        File tmpPath = new File(main_path_str);

        while(!tmpPath.isDirectory()){
            System.out.println("Input is not a valid path! Please re-enter a valid path:");
            main_path_str = path.next();
            try{
                tmpPath = new File(main_path_str);
                Path tmpPathPP = Paths.get(main_path_str);
            } catch(Exception e) {
                System.out.println("Input is not a valid path! Please re-enter a valid path:");
                main_path_str = path.next();
            }

        }

        Criteria criteria = new Criteria(main_path_str, extension, includeSubFolder);
        count(criteria);

    }

    public static void count(Criteria criteria){
        File mainPath = new File(criteria.getFolder_path());
        boolean includeSubFolder = criteria.isIncludeSubFolder();
        String extension = criteria.getExtension();

        if(mainPath.exists() && mainPath.isDirectory()){
            File file_list[] = mainPath.listFiles();
            scanRecurr(file_list, includeSubFolder, extension);
        }
        else {
            System.out.println("mainPath cannot be found! Please enter a valid path.");
            return;
        }
        System.out.println("There are " + countFile + " file(s) and " + countFolder + " folder(s) inside folder " + criteria.getFolder_path() + " with extension " + extension);

    }

    public static void scanRecurr(File[] file_list, boolean includeSubFolder, String extension){

        for(int i=0; i<file_list.length; i++){
            if(file_list[i].isFile()){
                String fileName = file_list[i].getName();
                if(fileName.substring(fileName.lastIndexOf(".")+1).equals(extension)) {
                    countFile++;
                }
            } else if(file_list[i].isDirectory()){
                countFolder++;
                if(includeSubFolder){
                    scanRecurr(file_list[i].listFiles(), includeSubFolder, extension);
                }
            }
        }

    }

}
