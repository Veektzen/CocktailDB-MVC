package com.view.factory;

import com.controller.factory.OperatingSystem;
import com.view.MainFrame;
import org.json.JSONException;

import java.awt.*;
import java.io.IOException;

public class Windows implements OperatingSystem {
    @Override
    public void view() throws JSONException, IOException, InterruptedException {
        MainFrame frame = new MainFrame("Windows", Color.BLACK, "assets/images/windows.png");
        frame.show();
    }
}
