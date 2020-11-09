package br.edu.unifacear.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import br.edu.unifacear.classes.Calcado;
import br.edu.unifacear.facade.CadastrarCalcadoFacade;
import br.edu.unifacear.facade.CalcadoFacade;


@ManagedBean(name="calcadoBean")
@RequestScoped
public class CalcadoController {
	
	private String diretorio;
	private Part arquivo;
	private String nomeArquivo;
	private Calcado calcado;
	
	
	
	public String getDiretorio() {
		return diretorio;
	}

	public void setDiretorio(String diretorio) {
		this.diretorio = diretorio;
	}

	public Part getArquivo() {
		return arquivo;
	}

	public void setArquivo(Part arquivo) {
		this.arquivo = arquivo;
	}

	public String getNomeArquivo() {
		return nomeArquivo;
	}

	public void setNomeArquivo(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	public CalcadoController() {
		this.calcado = new Calcado();
		this.diretorio = "C://temp//";
		
	}

	public Calcado getCalcado() {
		return calcado;
		
	}

	public void setCalcado(Calcado calcado) {
		this.calcado = calcado;
	}
	
		public void salvar() throws Exception {
				
				FacesContext context = FacesContext.getCurrentInstance();
			
				try {
					
					CadastrarCalcadoFacade facade = new CadastrarCalcadoFacade();
				
					
					this.calcado.setMarca(facade.listarMarca(this.calcado.getMarca()).get(0));    
					this.calcado.setCategoria(facade.listarCategoria(this.calcado.getCategoria().getDescricao()).get(0));
					this.calcado.setFornecedor(facade.listarFornecedor(this.calcado.getFornecedor()).get(0));
					
					lerTxt();
					facade.salvar(calcado);
					
					
					
				
					
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Calçado cadastrado com sucesso",""));
					
				
				}catch(Exception e) {
					context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Erro ao salvar","Verifique se selecionou uma imagem e confira os campos"));
				}
				
	}
		
		
		
		
		public void importa() throws Exception {
			
			
			try {
				
				
				String nomeArq = getFileName(this.arquivo.getName() + ".png");
				
				copyFile(nomeArq, arquivo.getInputStream());
				gerarTxt();
				this.calcado.setImagem(this.diretorio + this.nomeArquivo);
				
			}catch(Exception e) {
				throw new Exception("Erro");
			}
			
		}
		
		
		public void copyFile(String fileName, InputStream in) {
			try {
				// write the inputStream to a FileOutputStream
				OutputStream out = new FileOutputStream(new File(diretorio + fileName));
				int read = 0;
				byte[] bytes = new byte[1024];

				while ((read = in.read(bytes)) != -1) {
					out.write(bytes, 0, read);
				}

				in.close();
				out.flush();
				out.close();

				System.out.println("Novo arquivo criado '"+fileName+"'!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		
		public String getFileName(String nomeArquivo) {
			String data = "yyyy-MM-dd";
			String hora = "HH-mm-ss-SSS";
			String data1, hora1;

			java.util.Date agora = new java.util.Date();
			SimpleDateFormat formata = new SimpleDateFormat(data);
			data1 = formata.format(agora);
			formata = new SimpleDateFormat(hora);
			hora1 = formata.format(agora);
			this.nomeArquivo = data1 + "-" + hora1+"."+getExtensao(nomeArquivo);
			
			return  this.nomeArquivo;
			
		}
		
		public String getExtensao(String nomeArquivo)
	    {
			int posicaoPonto = nomeArquivo.lastIndexOf(".");
			int tamanhoString = nomeArquivo.length();
			return nomeArquivo.substring(posicaoPonto + 1, tamanhoString);  
	    }
		
		
		
		public void gerarTxt() throws IOException {
			
			Path caminho = Paths.get("C:/temp/nomeImagem.Txt");
			String texto =this.nomeArquivo;
			
			byte[] textoEmByte = texto.getBytes();
			
			try {

				Files.write(caminho, textoEmByte);
				
				
			}catch(Exception e) {
				
			}
			

		}
		

		public void lerTxt() {
			
			Path caminho = Paths.get("C:/temp/nomeImagem.txt");
			try {
				
				byte[] texto = Files.readAllBytes(caminho);
				String leitura = new String(texto);
				
				this.calcado.setImagem(this.diretorio+leitura);
				
				
				Files.deleteIfExists(caminho);
				
				
			}catch(Exception e) {
				
			}
			
		}
	
		
		
	public List<Calcado> listar(Calcado calcado, String pesquisa, String parametro) throws Exception{
		CalcadoFacade facade = new CalcadoFacade();
		return facade.listar(calcado, pesquisa, parametro);
	}
	
	public void adicionarMarca() {
		this.calcado.setMarca(new CadastrarCalcadoFacade().listarMarca(this.calcado.getMarca()).get(0));
	}
	
}
