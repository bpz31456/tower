package com.cdhenren.fetch.tools;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Baopz
 * @date 2018/05/04
 */
public final class FileTools {

    /**
     * 删除目录下的所有文件
     *
     * @param filepath
     * @return
     */
    @Deprecated
    public static boolean deleteFiles(String filepath) {
        File path = new File(filepath);
        boolean deleted = true;
        //清空下载的文件
        if (path.isDirectory()) {
            File[] fs = path.listFiles();
            assert fs != null;
            for (File file1 : fs) {
                if (!(deleted = file1.delete())) {
                    break;
                }
            }
        }
        return deleted;
    }

    /**
     * 删除某个文件
     *
     * @param filename
     * @return
     */
    public static boolean deleteFile(String filename) {
        return deleteFile(new File(filename));
    }

    public static boolean deleteFile(File file) {
        boolean deleted = true;
        //清空下载的文件
        if (file.exists() && file.isFile()) {
            deleted = file.delete();
        }
        return deleted;
    }

    /**
     * url解码
     *
     * @param files
     */
    @Deprecated
    public static boolean rename(File[] files) throws UnsupportedEncodingException, InterruptedException {
        /*boolean isSuccess = true;
        for (File file : files) {
            String txt = URLDecoder.decode(file.getAbsolutePath(), "UTF-8");
            isSuccess &= file.renameTo(new File(txt));
        }
        TimeUnit.SECONDS.sleep(2);
        return isSuccess;*/
        return false;
    }

    /**
     * 得到目录下的所有文件
     * @param path
     * @return
     * @throws IOException
     */
    public static List<String> list(String path,String filter) throws IOException {
        Stream<Path> list = Files.list(Paths.get(path));
        return list.map(Path::toString).filter(s -> {
            System.out.println(s);
           return s.contains(filter);}).collect(Collectors.toList());
    }

}
