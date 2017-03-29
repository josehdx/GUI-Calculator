import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
//import org.eclipse.wb.swt.SWTResourceManager;



public class Calc {

	protected Shell shell;
	private Text firstNumber;
	private Text secondNumber;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Calc window = new Calc();
			window.open();
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
		shell.setToolTipText("subtract");
		shell.setSize(450, 300);
		shell.setText("Simple Calculator");
		
		firstNumber = new Text(shell, SWT.BORDER);
		firstNumber.setBounds(37, 45, 135, 21);
		
		secondNumber = new Text(shell, SWT.BORDER);
		secondNumber.setBounds(37, 105, 135, 21);
		
		Label lblFirstNumber = new Label(shell, SWT.NONE);
		lblFirstNumber.setBounds(37, 24, 98, 15);
		lblFirstNumber.setText("First number");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBounds(37, 84, 100, 15);
		lblNewLabel.setText("Second number");

		final Label answerLabel = new Label(shell, SWT.NONE);
		//answerLabel.setFont(SWTResourceManager.getFont("Script", 24, SWT.BOLD));
		
		answerLabel.setBounds(37, 187, 192, 49);
		answerLabel.setText("The answer is:");

		Button plusButton = new Button(shell, SWT.NONE);
		plusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int number1,number2;
				try {
					number1 = Integer.parseInt(firstNumber.getText());
				}
				catch (Exception exc)
				{
					MessageDialog.openError(shell,"Error","bad first number");
					return;
				}
				try {
					number2 = Integer.parseInt(secondNumber.getText());
				}
				catch (Exception exc)
				{
					MessageDialog.openError(shell,"Error","bad second number");
					return;
				}
				int answer=number1+number2;
				answerLabel.setText("The answer is:" + answer);
			}
		});
		plusButton.setToolTipText("add");
		plusButton.setBounds(34, 138, 75, 25);
		plusButton.setText("+");
		
		Button minusButton = new Button(shell, SWT.NONE);
		minusButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int number1,number2;
				try {
					number1 = Integer.parseInt(firstNumber.getText());
				}
				catch (Exception exc)
				{
					MessageDialog.openError(shell,"Error","bad first number");
					return;
				}
				try {
					number2 = Integer.parseInt(secondNumber.getText());
				}
				catch (Exception exc)
				{
					MessageDialog.openError(shell,"Error","bad second number");
					return;
				}
				int answer=number1-number2;
				answerLabel.setText("The answer is:" + answer);
			}
		});
		minusButton.setBounds(117, 138, 75, 25);
		minusButton.setText("-");
		

	}
}