package quizgame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        loadDll();
        extractFile("/data/questions.csv");
        quizgame.Gui.main(args);
    }

    public static void loadDll() {
        // List of DLL files to load
        String[] dllFiles = {
            "/bin/api-ms-win-core-console-l1-1-0.dll",
            "/bin/api-ms-win-core-console-l1-2-0.dll",
            "/bin/api-ms-win-core-datetime-l1-1-0.dll",
            "/bin/api-ms-win-core-debug-l1-1-0.dll",
            "/bin/api-ms-win-core-errorhandling-l1-1-0.dll",
            "/bin/api-ms-win-core-file-l1-1-0.dll",
            "/bin/api-ms-win-core-file-l1-2-0.dll",
            "/bin/api-ms-win-core-file-l2-1-0.dll",
            "/bin/api-ms-win-core-handle-l1-1-0.dll",
            "/bin/api-ms-win-core-heap-l1-1-0.dll",
            "/bin/api-ms-win-core-interlocked-l1-1-0.dll",
            "/bin/api-ms-win-core-libraryloader-l1-1-0.dll",
            "/bin/api-ms-win-core-localization-l1-2-0.dll",
            "/bin/api-ms-win-core-memory-l1-1-0.dll",
            "/bin/api-ms-win-core-namedpipe-l1-1-0.dll",
            "/bin/api-ms-win-core-processenvironment-l1-1-0.dll",
            "/bin/api-ms-win-core-processthreads-l1-1-0.dll",
            "/bin/api-ms-win-core-processthreads-l1-1-1.dll",
            "/bin/api-ms-win-core-profile-l1-1-0.dll",
            "/bin/api-ms-win-core-rtlsupport-l1-1-0.dll",
            "/bin/api-ms-win-core-string-l1-1-0.dll",
            "/bin/api-ms-win-core-synch-l1-1-0.dll",
            "/bin/api-ms-win-core-synch-l1-2-0.dll",
            "/bin/api-ms-win-core-sysinfo-l1-1-0.dll",
            "/bin/api-ms-win-core-timezone-l1-1-0.dll",
            "/bin/api-ms-win-core-util-l1-1-0.dll",
            "/bin/api-ms-win-crt-conio-l1-1-0.dll",
            "/bin/api-ms-win-crt-convert-l1-1-0.dll",
            "/bin/api-ms-win-crt-environment-l1-1-0.dll",
            "/bin/api-ms-win-crt-filesystem-l1-1-0.dll",
            "/bin/api-ms-win-crt-heap-l1-1-0.dll",
            "/bin/api-ms-win-crt-locale-l1-1-0.dll",
            "/bin/api-ms-win-crt-math-l1-1-0.dll",
            "/bin/api-ms-win-crt-multibyte-l1-1-0.dll",
            "/bin/api-ms-win-crt-private-l1-1-0.dll",
            "/bin/api-ms-win-crt-process-l1-1-0.dll",
            "/bin/api-ms-win-crt-runtime-l1-1-0.dll",
            "/bin/api-ms-win-crt-stdio-l1-1-0.dll",
            "/bin/api-ms-win-crt-string-l1-1-0.dll",
            "/bin/api-ms-win-crt-time-l1-1-0.dll",
            "/bin/api-ms-win-crt-utility-l1-1-0.dll",
            "/bin/decora_sse.dll",
            "/bin/glass.dll",
            "/bin/glib-lite.dll",
            "/bin/gstreamer-lite.dll",
            "/bin/javafx_font.dll",
            "/bin/javafx_iio.dll",
            "/bin/jfxmedia.dll",
//            "/bin/jfxwebkit.dll",
            "/bin/msvcp140.dll",
            "/bin/msvcp140_1.dll",
            "/bin/msvcp140_2.dll",
            "/bin/prism_common.dll",
            "/bin/prism_d3d.dll",
            "/bin/prism_sw.dll",
            "/bin/ucrtbase.dll",
            "/bin/vcruntime140.dll",
            "/bin/vcruntime140_1.dll",
            "/bin/fxplugins.dll",
        };
        String[] soFiles = {
            "/lib/libprism_es2.so",
            "/lib/libprism_sw.so",
            "/lib/libgstreamer-lite.so",
            "/lib/libdecora_sse.so",
            // "/lib/libglass.so",
            // "/lib/libglassgtk3.so",
            "/lib/libprism_common.so",
            // "/lib/libavplugin-54.so",
            // "/lib/libavplugin-56.so",
            //"/lib/libavplugin-57.so",
            // "/lib/libavplugin-ffmpeg-56.so",
            // "/lib/libavplugin-ffmpeg-57.so",
            // "/lib/libavplugin-ffmpeg-58.so",
            // "/lib/libavplugin-ffmpeg-59.so",
            "/lib/libjavafx_font.so",
            "/lib/libjavafx_font_freetype.so",
            "/lib/libjavafx_font_pango.so",
            "/lib/libjavafx_iio.so",
            "/lib/libjfxmedia.so",
            "/lib/libfxplugins.so",
//            "/lib/libjfxwebkit.so",
        };
        //System.out.println(System.getProperty("java.library.path"));

        if (System.getProperty("os.name").split(" ")[0].equals("Windows")) {
            // Add dll path to java library path same as `export PATH=$PATH:/new/path/here` on linux
            System.setProperty("java.library.path", System.getProperty("java.library.path") + ";" + System.getProperty("java.io.tmpdir") + "/bin");
            for (String dllFile : dllFiles) {
                extractFile(dllFile, System.getProperty("java.io.tmpdir"));
    
                // Load the DLL
                System.out.println("Loading dll " + dllFile);
                System.load(System.getProperty("java.io.tmpdir") + dllFile);
            }
        } else if (System.getProperty("os.name").split(" ")[0].equals("Linux")) {
            System.setProperty("java.library.path", System.getProperty("java.library.path") + ";" + System.getProperty("java.io.tmpdir") + "/lib");
            for (String soFile: soFiles) {
                extractFile(soFile, System.getProperty("java.io.tmpdir"));
    
                // Load the DLL
                System.out.println("Loading " + soFile);
                System.load(System.getProperty("java.io.tmpdir") + soFile);
            }
        }
    }

    public static void extractFile(String fileToExtract) {
        extractFile(fileToExtract, ".");
    }
    public static void extractFile(String fileToExtract, String outputDirectory) {
        try {
            InputStream fileInputStream = Main.class.getResourceAsStream(fileToExtract);

            if (fileInputStream != null) {
                //File outputFile = new File(outputDirectory, new File(fileToExtract).getName());
                File outputFile = new File(outputDirectory + fileToExtract);

                // Ensure the parent directory exists
                File parentDir = outputFile.getParentFile();
                if (parentDir != null) {
                    parentDir.mkdirs();
                }

                try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }

            } else {
                throw new IOException("File " + fileToExtract + " not found in the JAR file.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
