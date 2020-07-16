package euler;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.awt.font.TextAttribute;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.util.Arrays;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.HelpListener;
import org.eclipse.swt.events.HelpEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.TextLayout;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Spinner;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;

public class Thing {
	protected Shell shell;
	private Text txtEqt;
	private Text txtRes1;
	private Label txtValorDeR;
	private Text txtDescomp;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Thing window = new Thing();
			window.open();
			String result="";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("Calculadora de exponencial de Base Euler (e)");
		shell.setLayout(null);
		
		Button btnSalir = new Button(shell, SWT.NONE);
		btnSalir.setBounds(349, 226, 75, 25);
		btnSalir.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Runtime.getRuntime().exit(0);
			}
		});
		btnSalir.setToolTipText("Cerrar la calculadora");
		btnSalir.setText("Salir");
		
		Label lblEcuacinYbe = new Label(shell, SWT.NONE);
		lblEcuacinYbe.setBounds(10, 10, 92, 15);
		lblEcuacinYbe.setText("Ecuaci\u00F3n: y=b*e\u02B3\u02E3");
		
		Label lblTamaoInicialDe = new Label(shell, SWT.NONE);
		lblTamaoInicialDe.setBounds(10, 34, 219, 15);
		lblTamaoInicialDe.setText("Tama\u00F1o inicial de la muestra (valor de b): ");
		
		Spinner spinner_b = new Spinner(shell, SWT.BORDER);
		spinner_b.setMaximum(100000);
		spinner_b.setMinimum(1);
		spinner_b.setBounds(235, 31, 65, 22);
		
		Label lblPorcentajeDeCrecimiento = new Label(shell, SWT.NONE);
		lblPorcentajeDeCrecimiento.setBounds(10, 62, 204, 15);
		lblPorcentajeDeCrecimiento.setText("Porcentaje de crecimiento (valor de r): ");
		
		Spinner spinner_r = new Spinner(shell, SWT.BORDER);
		spinner_r.setMinimum(1);
		spinner_r.setBounds(235, 59, 65, 22);
		
		Label lblPeriodoParaCrecimiento = new Label(shell, SWT.NONE);
		lblPeriodoParaCrecimiento.setBounds(10, 90, 201, 15);
		lblPeriodoParaCrecimiento.setText("Periodo para crecimiento (valor de x): ");
		
		Spinner spinner_x = new Spinner(shell, SWT.BORDER);
		spinner_x.setToolTipText("x significa un periodo de tiempo cualquiera, usualmente a\u00F1os. Sino necesita modificar el valor por favor d\u00E9jese en 1");
		spinner_x.setMaximum(100000);
		spinner_x.setMinimum(1);
		spinner_x.setBounds(235, 87, 65, 22);
		
		Label lblEcuacinResultante = new Label(shell, SWT.NONE);
		lblEcuacinResultante.setBounds(10, 114, 109, 15);
		lblEcuacinResultante.setText("Ecuaci\u00F3n resultante: ");
		
		txtEqt = new Text(shell, SWT.BORDER);
		txtEqt.setToolTipText("Ecuación saliente");
		txtEqt.setText("y=b*e\u02B3\u02E3");
		txtEqt.setEditable(false);
		txtEqt.setBounds(138, 111, 76, 21);
		
		txtRes1 = new Text(shell, SWT.BORDER);
		txtRes1.setToolTipText("Resultado de realizar la ecuaci\u00F3n considerando x");
		txtRes1.setEditable(false);
		txtRes1.setBounds(138, 165, 76, 21);
		
		Label lblResultadox = new Label(shell, SWT.NONE);
		lblResultadox.setBounds(10, 168, 72, 15);
		lblResultadox.setText("Resultado +x:");
		
		txtValorDeR = new Label(shell, SWT.NONE);
		txtValorDeR.setText("Valor de r sobre 100");
		txtValorDeR.setBounds(306, 62, 114, 21);
		
		Button btnCalcular = new Button(shell, SWT.NONE);
		btnCalcular.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				int bravo=(int)spinner_b.getSelection();
				double romeo=((double)spinner_r.getSelection()/100)*(double)spinner_x.getSelection();
				int xray=(int)spinner_x.getSelection();
				
				
				double powSaver=(double)spinner_r.getSelection()/100*(double)(spinner_x.getSelection());
				
				System.out.println(bravo+"\n"+romeo+"\n"+xray+"\n"+powSaver+"\n");
				
				double numRes=(double)spinner_b.getSelection()*(double)(Math.exp(powSaver));
				String sampleEq="y=b*e\\u02B3\\u02E3";
				
				double eulerStuff=Math.round(Math.exp(spinner_r.getSelection()/100));
				
				String eqt=new String("y="+Integer.toString(spinner_b.getSelection())+"("+eulerStuff);
				
				System.out.println(eqt+"\n"+sampleEq.indexOf('\u02E3')+"\n"+eqt+"\n");
				
				txtEqt.setText(eqt);
				txtEqt.setSize (eqt.length()*10, 21);
				txtRes1.setText(Double.toString(numRes));
				txtValorDeR.setText(Integer.toString(spinner_r.getSelection())+"/100="+Double.toString(spinner_r.getSelection()/100));
				txtRes1.setSize(txtRes1.getCharCount()*10, 21);
				
				String eqtFull=Double.toString(Math.exp(spinner_r.getSelection()/100));
				String eqtCut=new String();
				
				
				
				
				txtDescomp.setText("b="+spinner_b.getSelection()+", e\u02B3="+eqtFull+", "+""+"+x="+spinner_x.getSelection());
				txtDescomp.setSize(txtDescomp.getCharCount()*10, 21);
				
				System.out.println(numRes);
				
				
				
				System.out.println("1. "+eqtCut);
			}
		});
		btnCalcular.setBounds(10, 226, 75, 25);
		btnCalcular.setToolTipText("Realizar los c\u00E1lculos");
		btnCalcular.setText("Calcular");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(10, 141, 55, 15);
		lblNewLabel.setText("Donde:");
		
		txtDescomp = new Text(shell, SWT.BORDER);
		txtDescomp.setEditable(false);
		txtDescomp.setText("Descomp.");
		txtDescomp.setBounds(138, 138, 76, 21);
		
		Label lblEsteProgramaEst = new Label(shell, SWT.NONE);
		lblEsteProgramaEst.setBounds(10, 192, 308, 15);
		lblEsteProgramaEst.setText("Este programa está incompleto hacia el 16 de Julio de 2020");

	}
}
