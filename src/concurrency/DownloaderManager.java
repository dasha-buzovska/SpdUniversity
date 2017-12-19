package concurrency;

import concurrency.badUrlList.Content18Plus;
import concurrency.badUrlList.Extensions;

import java.util.Arrays;

public class DownloaderManager {

    public static boolean endsWithWrongExtension(String url) {
        return Arrays.stream(Extensions.values()).anyMatch(extension -> url.endsWith(extension.getExtension()));
    }

    public static boolean contains18PlusContent(String url) {
        return Arrays.stream(Content18Plus.values()).anyMatch(content18Plus -> url.contains(content18Plus.toString().toLowerCase()));
    }
}
