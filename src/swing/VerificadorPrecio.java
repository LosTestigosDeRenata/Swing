package swing;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class VerificadorPrecio extends InputVerifier {
	
    @Override
    public boolean verify(JComponent input) {
        String texto = ((JTextField) input).getText();
        try {
            double valor = new Double(texto);
            return true; 
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
