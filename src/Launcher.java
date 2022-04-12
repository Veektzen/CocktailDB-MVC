
import com.view.factory.ChooseDialog;
import org.json.JSONException;

import java.io.IOException;

public class Launcher {
    public static void main(String[] args) throws JSONException, IOException, InterruptedException {

        ChooseDialog startDialog = new ChooseDialog();
        startDialog.setVisible(true);


    }
}

