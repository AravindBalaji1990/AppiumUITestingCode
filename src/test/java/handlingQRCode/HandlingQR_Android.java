package handlingQRCode;

import com.google.zxing.*;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HandlingQR_Android {
    public static void main(String[] args) throws MalformedURLException {

// File path of the QR code image
        String filePath = System.getProperty("user.dir") + "/src/test/resources/qrcodesample/qr_code_1.png";

        File qrFile = new File(filePath);

        // Decode and print the QR code text
        String qrText = decodeQRCode(qrFile);
        if (qrText != null) {
            System.out.println("QR Code Text: " + qrText);
        } else {
            System.out.println("QR Code not found in the image.");
        }
    }

    public static String decodeQRCode(File qrImage) throws NotFoundException {
        try {
            BufferedImage bufferedImage = ImageIO.read(qrImage);

            // Convert to grayscale to improve detection
            BufferedImage grayscaleImage = new BufferedImage(
                    bufferedImage.getWidth(), bufferedImage.getHeight(),
                    BufferedImage.TYPE_BYTE_GRAY);
            grayscaleImage.getGraphics().drawImage(bufferedImage, 0, 0, null);

            // Try to enhance image contrast
            LuminanceSource source = new BufferedImageLuminanceSource(grayscaleImage);
            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

            Result result = new MultiFormatReader().decode(bitmap);
            return result.getText();
        } catch (IOException e) {
            System.out.println("Error reading QR Code image: " + e.getMessage());
            return null;
        } catch (NotFoundException | com.google.zxing.NotFoundException e) {
            System.out.println("QR Code not found in image. Try adjusting the screenshot.");
            return null;
        }
    }
}
