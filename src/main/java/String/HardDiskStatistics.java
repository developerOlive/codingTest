package String;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HardDiskStatistics {

    /*
    your computer's hard drive is almost full. In order to make some space, you need to compile some file statistics. 
    You want to know how many bytes of memory each file type is consuming. 
    Each file has a name, and the part of the name after the last dot is called the file extension, 
    which identifies what type of file it is. We distinguish four broad types of file.
    
    music (only extensions : mp3, aac, flac)
    image (only extensions: jpg, bmp, gif)
    movie (only extensions : mp4, avi, mkv)
    other (all other extensions; for example: 7z, txt, zip)
    
    your receive string S, containing a list of all the files on your computer 
    (each file appears on a separate line). 
    Each line contains a file name and the file name and the file's size in bytes,
    separated by a space. For example, string S could look like :
    
    "my.song.mp3 11b
    greatSong.flac 1000b
    video.mp4 200b
    movie.mkv 10000b
    not3.txt 5b
    game.exe 100b"
    
    there are two music files (my.song.mp3 and greatSong.flac, of size 11 and 1000 bytes respectively).
    There are no images files.
    We have two movies files (video.mp4 and movie.mkv of size 200 and 10000 bytes.)
    There are two files of other types (not3.txt and game.exe of size 5 and 100 bytes).
    In total there are 1011 bytes of music, 0 bytes of images, 
    10200 bytes of movies and 105 bytes of other files.
    
    that, given string S describing the files on disk,
    returns a string containing four rows, describing music, images,  movies and other file types respectively. 
    Each row should consist of a file type and the number of bytes consumed by files of 
    that type on the disk(use format "<<type>><<size>>b",where<<type>> is the files' type and <<size>> is the total file size of this group).
    
    For instance, give string S as shown above, your function should return:
    
    "music 1011b
    images 0b
    movies 10200b"
    
     */

    public static void main(String[] args) {
        String S = "my.song.mp3 11b\n" + "greatSong.flac 1000b\n"
                + "not3.txt 5b\n" + "video.mp4 200b\n" + "game.exe 100b\n"
                + "mov!e.mkv 10000b";
        System.out.println(solution3(S));
    }

    public static String solution1(String S) {

        Set<String> music = new HashSet<>(List.of("mp3", "aac", "flac"));
        Set<String> images = new HashSet<>(List.of("jpg", "bmp", "gif"));
        Set<String> movies = new HashSet<>(List.of("mp4", "avi", "mkv"));

        Map<String, BigInteger> fileMap = new HashMap<>();
        fileMap.put("music", new BigInteger("0"));
        fileMap.put("images", new BigInteger("0"));
        fileMap.put("movies", new BigInteger("0"));
        fileMap.put("other", new BigInteger("0"));

        String[] files = S.split("\n");

        for (int i = 0; i < files.length; i++) {

            String hardDisk = files[i].substring(
                    files[i].lastIndexOf(".") + 1,
                    files[i].length() - 1);

            String[] eachFile = hardDisk.split(" ");

            if (music.contains(eachFile[0])) {
                fileMap.put("music", fileMap.get("music").add(new BigInteger(eachFile[1])));
            } else if (images.contains(eachFile[0])) {
                fileMap.put("images", fileMap.get("images").add(new BigInteger(eachFile[1])));
            } else if (movies.contains(eachFile[0])) {
                fileMap.put("movies", fileMap.get("movies").add(new BigInteger(eachFile[1])));
            } else
                fileMap.put("other", fileMap.get("other").add(new BigInteger(eachFile[1])));
        }

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("music" + " ").append(fileMap.get("music")).append("b\n");
        stringBuilder.append("images" + " ").append(fileMap.get("images")).append("b\n");
        stringBuilder.append("movies" + " ").append(fileMap.get("movies")).append("b\n");
        stringBuilder.append("other" + " ").append(fileMap.get("other")).append("b\n");

        return stringBuilder.toString();
    }

    public static String solution2(String S) {

        Set<String> music = new HashSet<>(List.of("mp3", "aac", "flac"));
        Set<String> images = new HashSet<>(List.of("jpg", "bmp", "gif"));
        Set<String> movies = new HashSet<>(List.of("mp4", "avi", "mkv"));


        Map<String, BigInteger> fileMap = new HashMap<>();
        fileMap.put("music", BigInteger.ZERO);
        fileMap.put("images", BigInteger.ZERO);
        fileMap.put("movies", BigInteger.ZERO);
        fileMap.put("other", BigInteger.ZERO);

        String[] files = S.split("\n");

        for (int i = 0; i < files.length; i++) {

            String[] fileData = files[i].split(" ");
            String extension = fileData[0].substring(fileData[0].lastIndexOf(".") + 1);
            String fileSizeString = fileData[1].replaceAll("[^0-9]", "");
            BigInteger fileSize = new BigInteger(fileSizeString);

            if (music.contains(extension)) {
                fileMap.put("music", fileMap.get("music").add(fileSize));
            } else if (images.contains(extension)) {
                fileMap.put("images", fileMap.get("images").add(fileSize));
            } else if (movies.contains(extension)) {
                fileMap.put("movies", fileMap.get("movies").add(fileSize));
            } else {
                fileMap.put("other", fileMap.get("other").add(fileSize));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append("music ").append(fileMap.get("music")).append("b\n");
        result.append("images ").append(fileMap.get("images")).append("b\n");
        result.append("movies ").append(fileMap.get("movies")).append("b\n");
        result.append("other ").append(fileMap.get("other")).append("b\n");

        return result.toString();
    }

    public static String solution3(String S) {

        Set<String> music = Set.of("mp3", "aac", "flac");
        Set<String> images = Set.of("jpg", "bmp", "gif");
        Set<String> movies = Set.of("mp4", "avi", "mkv");

        Map<String, BigInteger> fileMap = Stream.of(S.split("\n"))
                .map(line -> line.split(" "))
                .map(parts -> {
                    String extension = parts[0].substring(parts[0].lastIndexOf(".") + 1);
                    String fileSizeString = parts[1].replaceAll("[^0-9]", "");
                    BigInteger fileSize = new BigInteger(fileSizeString);

                    if (music.contains(extension)) {
                        return new AbstractMap.SimpleEntry<>("music", fileSize);
                    } else if (images.contains(extension)) {
                        return new AbstractMap.SimpleEntry<>("images", fileSize);
                    } else if (movies.contains(extension)) {
                        return new AbstractMap.SimpleEntry<>("movies", fileSize);
                    } else {
                        return new AbstractMap.SimpleEntry<>("other", fileSize);
                    }
                })
                .collect(Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.reducing(BigInteger.ZERO, BigInteger::add))
                ));

        StringBuilder result = new StringBuilder();
        result.append("music ").append(fileMap.getOrDefault("music", BigInteger.ZERO)).append("b\n");
        result.append("images ").append(fileMap.getOrDefault("images", BigInteger.ZERO)).append("b\n");
        result.append("movies ").append(fileMap.getOrDefault("movies", BigInteger.ZERO)).append("b\n");
        result.append("other ").append(fileMap.getOrDefault("other", BigInteger.ZERO)).append("b\n");

        return result.toString();
    }
}
