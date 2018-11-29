package com.lakala.appcomponent.bsdiff;


/**
 * 合并工具类
 */
public class PatchUtils {

    public static PatchUtils getInstance() {
        return PatchInstance.mInstance;
    }

    private static class PatchInstance {
        private static final PatchUtils mInstance = new PatchUtils();
    }

    static {
        System.loadLibrary("ApkPatchDiffUtils");
    }

    /**
     * native方法 使用路径为oldApkPath的apk与路径为patchPath的补丁包，合成新的apk，并存储于newApkPath
     * <p>
     * 返回：0，说明操作成功
     *
     * @param oldApkPath 示例:/sdcard/old.apk
     * @param newApkPath 示例:/sdcard/new.apk
     * @param patchPath  示例:/sdcard/xx.patch
     * @return
     */
    public native int patch(String oldApkPath, String newApkPath, String patchPath);
}
