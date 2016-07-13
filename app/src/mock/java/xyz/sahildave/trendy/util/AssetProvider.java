package xyz.sahildave.trendy.util;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import timber.log.Timber;

/**
 * Created by sahil on 2/3/16.
 */
public class AssetProvider {
    private final static String LOG_TAG = AssetProvider.class.getName();

    private Map<String, String> fileCacheMap = new HashMap<>();

    // --------------------------------------------------------------------------------------------
    // init methods
    private static AssetProvider _instance;
    public static void init(){
        _instance = null;
    }

    public static void nullify() {
        _instance = null;
    }

    public synchronized static AssetProvider getInstance() {
        if(_instance == null) {
            _instance = new AssetProvider();
        }
        return _instance;
    }

    // --------------------------------------------------------------------------------------------
    // public methods

    public String readFromAssets(Context context, String fileName) {
        try {
            if(canReturnFromFileCache(fileName)) return getFileFromCache(fileName);

            String returnString = readFromAssetsInner(openAssetFile(context, fileName));
            fileCacheMap.put(fileName, returnString);
            return returnString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    // --------------------------------------------------------------------------------------------
    // private Helpers

    private String readFromAssetsInner(InputStream fIn) {
        try {
            Timber.d("Returning from file");
            StringBuilder stringBuilder = new StringBuilder();
            InputStreamReader isr = new InputStreamReader(fIn);
            BufferedReader input = new BufferedReader(isr);
            String line;
            while ((line = input.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append("\n");
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private InputStream openAssetFile(Context context, String fileName) throws IOException {
        return context.getAssets().open(fileName);
    }

    private String getFileFromCache(String fileName) {
        Timber.d("Returning from cache");
        return fileCacheMap.get(fileName);
    }

    private boolean canReturnFromFileCache(String fileName) {
        return fileCacheMap!=null &&
                fileCacheMap.containsKey(fileName) &&
                (fileCacheMap.get(fileName) != null);
    }
}
