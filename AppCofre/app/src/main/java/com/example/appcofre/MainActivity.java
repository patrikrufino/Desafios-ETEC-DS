package com.example.appcofre;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    TextView txtServicoProg;
    EditText edtNomeProg;
    EditText edtUsuarioProg;
    EditText edtSenhaProg;
    int quantidadeRegistros;
    int registroAtual;
    int idCredencialAtual;
    credencialModel credencial = new credencialModel();
    bdModel bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtServicoProg = (TextView) findViewById(R.id.txtServico);
        edtNomeProg = (EditText) findViewById(R.id.edtServico);
        edtUsuarioProg = (EditText) findViewById(R.id.edtUsuario);
        edtSenhaProg = (EditText) findViewById(R.id.edtSenha);
        carregarRegistroZero();
    }
    public void clickBtnDeletar(View v)
    {
        credencial.setId(idCredencialAtual);
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        dialogDelete();
        bd = new bdModel(getApplicationContext());
        bd.delete(bd.getTabela(), credencial);
        limpar();
        carregarRegistroZero();
    }
    public void clickBtnAlterar(View v)
    {
        credencial.setId(idCredencialAtual);
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        bd = new bdModel(getApplicationContext());
        bd.update(bd.getTabela(), credencial);
        dialogEdit();
        carregarRegistroZero();

    }
    public void clickBtnCadastrar(View v)
    {
        credencial.setNome(edtNomeProg.getText().toString());
        credencial.setUsuario(edtUsuarioProg.getText().toString());
        credencial.setSenha(edtSenhaProg.getText().toString());
        bd = new bdModel(getApplicationContext());
        bd.insert(bdModel.getTabela(), credencial);
        dialogSuccess();
        carregarRegistroZero();

    }
    public void clickBtnNovo(View v)
    {
        limpar();
    }
    public void clickBtnAnterior(View v)
    {
        if(quantidadeRegistros != 0)
        {
            if(registroAtual > 0)
            {
                registroAtual = registroAtual - 1;
                carregarDados(registroAtual);
            }
        }
    }
    public void clickBtnProximo(View v)
    {
        if(quantidadeRegistros != 0)
        {
            if(registroAtual < quantidadeRegistros - 1)
            {
                registroAtual = registroAtual + 1;
                carregarDados(registroAtual);
            }
        }
    }
    public void limpar()
    {
        edtNomeProg.setText("");
        edtUsuarioProg.setText("");
        edtSenhaProg.setText("");
        txtServicoProg.setText("Serviço:");
        edtNomeProg.requestFocus();
    }
    public void carregarDados(int i) {
        bd = new bdModel(getApplicationContext());
        ArrayList<credencialModel> arrayCredencialModel;
        arrayCredencialModel = bd.select();
        quantidadeRegistros = arrayCredencialModel.size();
        if(quantidadeRegistros != 0){
            credencialModel credencialModel = arrayCredencialModel.get(i);
            txtServicoProg.setText("Serviço " + String.valueOf(credencialModel.getId()) + ":");
            idCredencialAtual = credencialModel.getId();
            edtNomeProg.setText(credencialModel.getNome());
            edtUsuarioProg.setText(credencialModel.getUsuario());
            edtSenhaProg.setText(credencialModel.getSenha());
        }
    }
    public void carregarRegistroZero(){
        registroAtual = 0;
        carregarDados(registroAtual);
    }

    public void dialogSuccess() {
        AlertDialog.Builder msgBoxSucces = new AlertDialog.Builder(this);
        msgBoxSucces.setTitle("Cadastrando...");
        msgBoxSucces.setIcon(android.R.drawable.ic_menu_save);
        msgBoxSucces.setMessage("Você esta adicioanando uma nova credencial.");
        msgBoxSucces.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
        msgBoxSucces.show();
    }

    public void dialogDelete() {
        AlertDialog.Builder msgBoxDelete = new AlertDialog.Builder(this);
        msgBoxDelete.setTitle("Excluindo...");
        msgBoxDelete.setIcon(android.R.drawable.ic_menu_delete);
        msgBoxDelete.setMessage("Você excluiu esta credencial!");
        msgBoxDelete.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Exclusão realizada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
        msgBoxDelete.show();
    }

    public void dialogEdit() {
        AlertDialog.Builder msgBoxEdit = new AlertDialog.Builder(this);
        msgBoxEdit.setTitle("Alterando...");
        msgBoxEdit.setIcon(android.R.drawable.ic_menu_edit);
        msgBoxEdit.setMessage("Você esta alterando está credencial!");
        msgBoxEdit.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Alterção realizada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });
        msgBoxEdit.show();
    }

}