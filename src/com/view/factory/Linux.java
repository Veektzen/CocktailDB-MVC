package com.view.factory;

import com.controller.factory.OperatingSystem;
import com.view.MainFrame;
import org.json.JSONException;

import java.awt.*;
import java.io.IOException;

public class Linux implements OperatingSystem {
    @Override
    public void view() throws JSONException, IOException, InterruptedException {
        MainFrame frame = new MainFrame("Linux", Color.WHITE, "assets/images/linux.png");
        frame.show();
    }

}
