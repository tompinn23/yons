package one.tlph.yonside.renderer;

public class GLData {
    public static float[] Top = {
            -0.5f, 0.5f, -0.5f,
            0.5f, 0.5f, -0.5f,
            0.5f, 0.5f,  0.5f,
            -0.5f, 0.5f, 0.5f
    };

    public static float[] Bottom = {
            -0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f, -0.5f,  0.5f,
            -0.5f, -0.5f,  0.5f
    };

    public static float[] North = {
            -0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, 0.5f,
            0.5f,  0.5f, 0.5f,
            -0.5f, -0.5f, 0.5f
    };

    public static float[] South = {
            -0.5f, -0.5f, -0.5f,
            0.5f, -0.5f, -0.5f,
            0.5f,  0.5f, -0.5f,
            -0.5f,  0.5f, -0.5f,
    };

    public static float[] East = {
            0.5f, 0.5f, 0.5f,
            0.5f, 0.5f,-0.5f,
            0.5f,-0.5f,-0.5f,
            0.5f,-0.5f, 0.5f
    };

    public static float[] West = {
            -0.5f, 0.5f, 0.5f,
            -0.5f, 0.5f,-0.5f,
            -0.5f,-0.5f,-0.5f,
            -0.5f,-0.5f, 0.5f
    };


    public static float[] TopTex = {
            0.0f, 0.0f,
            1.0f / 6, 0.0f,
            1.0f / 6, 1.0f,
            0.0f, 1.0f
    };

    public static float[] BottomTex = {
            1.0f / 6, 0.0f,
            2.0f / 6, 0.0f,
            2.0f / 6, 1.0f,
            1.0f / 6, 1.0f
    };

    public static float[] NorthTex = {
            2.0f / 6, 0.0f,
            3.0f / 6, 0.0f,
            3.0f / 6, 1.0f,
            2.0f / 6, 1.0f
    };

    public static float[] SouthTex = {
            3.0f / 6, 0.0f,
            4.0f / 6, 0.0f,
            4.0f / 6, 1.0f,
            3.0f / 6, 1.0f
    };

    public static float[] EastTex = {
            4.0f / 6, 0.0f,
            5.0f / 6, 0.0f,
            5.0f / 6, 1.0f,
            4.0f / 6, 1.0f
    };

    public static float[] WestTex = {
            5.0f / 6, 0.0f,
            6.0f / 6, 0.0f,
            6.0f / 6, 1.0f,
            5.0f / 6, 1.0f
    };

}
