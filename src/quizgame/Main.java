package quizgame;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
// import java.nio.file.Path;
// import java.nio.file.Files;

public class Main {
    public static void main(String[] args) {
        loadDll();
        quizgame.Gui.main(args);
    }

    public static void loadDll() {
        // List of DLL files to load
        String[] dllFiles = {
            "/api-ms-win-core-console-l1-1-0.dll",
            "/api-ms-win-core-console-l1-2-0.dll",
            "/api-ms-win-core-datetime-l1-1-0.dll",
            "/api-ms-win-core-debug-l1-1-0.dll",
            "/api-ms-win-core-errorhandling-l1-1-0.dll",
            "/api-ms-win-core-file-l1-1-0.dll",
            "/api-ms-win-core-file-l1-2-0.dll",
            "/api-ms-win-core-file-l2-1-0.dll",
            "/api-ms-win-core-handle-l1-1-0.dll",
            "/api-ms-win-core-heap-l1-1-0.dll",
            "/api-ms-win-core-interlocked-l1-1-0.dll",
            "/api-ms-win-core-libraryloader-l1-1-0.dll",
            "/api-ms-win-core-localization-l1-2-0.dll",
            "/api-ms-win-core-memory-l1-1-0.dll",
            "/api-ms-win-core-namedpipe-l1-1-0.dll",
            "/api-ms-win-core-processenvironment-l1-1-0.dll",
            "/api-ms-win-core-processthreads-l1-1-0.dll",
            "/api-ms-win-core-processthreads-l1-1-1.dll",
            "/api-ms-win-core-profile-l1-1-0.dll",
            "/api-ms-win-core-rtlsupport-l1-1-0.dll",
            "/api-ms-win-core-string-l1-1-0.dll",
            "/api-ms-win-core-synch-l1-1-0.dll",
            "/api-ms-win-core-synch-l1-2-0.dll",
            "/api-ms-win-core-sysinfo-l1-1-0.dll",
            "/api-ms-win-core-timezone-l1-1-0.dll",
            "/api-ms-win-core-util-l1-1-0.dll",
            "/api-ms-win-crt-conio-l1-1-0.dll",
            "/api-ms-win-crt-convert-l1-1-0.dll",
            "/api-ms-win-crt-environment-l1-1-0.dll",
            "/api-ms-win-crt-filesystem-l1-1-0.dll",
            "/api-ms-win-crt-heap-l1-1-0.dll",
            "/api-ms-win-crt-locale-l1-1-0.dll",
            "/api-ms-win-crt-math-l1-1-0.dll",
            "/api-ms-win-crt-multibyte-l1-1-0.dll",
            "/api-ms-win-crt-private-l1-1-0.dll",
            "/api-ms-win-crt-process-l1-1-0.dll",
            "/api-ms-win-crt-runtime-l1-1-0.dll",
            "/api-ms-win-crt-stdio-l1-1-0.dll",
            "/api-ms-win-crt-string-l1-1-0.dll",
            "/api-ms-win-crt-time-l1-1-0.dll",
            "/api-ms-win-crt-utility-l1-1-0.dll",
            "/decora_sse.dll",
            "/glass.dll",
            "/glib-lite.dll",
            "/gstreamer-lite.dll",
            "/javafx_font.dll",
            "/javafx_iio.dll",
            "/jfxmedia.dll",
//            "/jfxwebkit.dll",
            "/msvcp140.dll",
            "/msvcp140_1.dll",
            "/msvcp140_2.dll",
            "/prism_common.dll",
            "/prism_d3d.dll",
            "/prism_sw.dll",
            "/ucrtbase.dll",
            "/vcruntime140.dll",
            "/vcruntime140_1.dll",
            "/fxplugins.dll",
        };
        System.setProperty("java.library.path", System.getProperty("java.io.tmpdir"));

        for (String dllFile : dllFiles) {
            try {
                InputStream dllInputStream = Main.class.getResourceAsStream("/bin" + dllFile);
                File extractedDllFile = new File(System.getProperty("java.io.tmpdir") + dllFile);

                // Create parent directories if they don't exist
                extractedDllFile.getParentFile().mkdirs();

                FileOutputStream dllOutputStream = new FileOutputStream(extractedDllFile);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = dllInputStream.read(buffer)) != -1) {
                    dllOutputStream.write(buffer, 0, bytesRead);
                }

                dllInputStream.close();
                dllOutputStream.close();

                // Load the DLL
                System.out.println("Loading " + dllFile);
                System.load(extractedDllFile.getAbsolutePath());
            } catch (IOException e) {
                System.out.println("Import error: " + dllFile);
                e.printStackTrace();
            }
        }
    }
}
