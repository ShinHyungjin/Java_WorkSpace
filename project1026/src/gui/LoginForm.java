package gui;
import java.awt.*;
public class LoginForm extends Frame 
{
	Label la_id;
	Label la_pass;
	TextField t_id;
	TextField t_pass;
	Button bt_login;
	Button bt_regist;
	Panel p_center;
	Panel p_south;

	public LoginForm() {
		la_id = new Label("ID");
		la_pass = new Label("password");
		t_id = new TextField(15);
		t_pass = new TextField(15);
		bt_login = new Button("로그인");
		bt_regist = new Button("가입");
		p_center = new Panel();
		p_south = new Panel();

		p_center.setBackground(new Color(255,0,0));

		this.add(p_center, BorderLayout.CENTER);

		p_south.setBackground(Color.YELLOW);
		this.add(p_south, BorderLayout.SOUTH);

		p_center.setLayout(new GridLayout(2,2));
		p_center.add(la_id);
		p_center.add(t_id);
		p_center.add(la_pass);
		p_center.add(t_pass);

		p_south.add(bt_login);
		p_south.add(bt_regist);

		this.setSize(500,500);
		this.setVisible(true);
	}

	public static void main(String[] args) 
	{
		LoginForm lf = new LoginForm();
	}
}
