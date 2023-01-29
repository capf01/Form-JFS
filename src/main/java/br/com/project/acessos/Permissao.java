package br.com.project.acessos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public enum Permissao {
	ADMIN("ADMIN", "Administrador"), USER("USER", "Usuário Padrão"),
	CADASTRO_ACESSAR("CADASTRO_ACESSAR", "Cadastro - Acessar"),
	MENSAGEM_ACESSAR("MENSAGEM_ACESSAR", "Mensagem recebida - Acessar"),

	USUARIO_ACESSAR("USUARIO_ACESSAR", "USUARIO - Acessar"), 
	USUARIO_NOVO("USUARIO_NOVO", "USUARIO - Novo"),
	USUARIO_EDITAR("USUARIO_EDITAR", "USUARIO - Editar"), 
	USUARIO_EXCLUIR("USUARIO_EXCLUIR", "USUARIO - Excluir");

	private String valor = "";
	private String descricao = "";

	private Permissao(String name, String descricao) {
		this.valor = name;
		this.descricao = descricao;
	}

	private Permissao() {

	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getValor() {
		return valor;
	}

	@Override
	public String toString() {
		return getValor();
	}

	public static List<Permissao> getListPermissao() {
		List<Permissao> permissoes = new ArrayList<Permissao>();
		for (Permissao permissao : Permissao.values()) {
			permissoes.add(permissao);
		}

		Collections.sort(permissoes, new Comparator<Permissao>() {

			@Override
			public int compare(Permissao o1, Permissao o2) {

				return new Integer(o1.ordinal()).compareTo(new Integer(o2.ordinal()));
			}

		});

		return permissoes;
	}
}
