# Tutorial de Uso

## Passo 1

Primeiro é necessário fazer a instalação do programa <a href="https://ollama.com/download"> Ollama </a> e de alguma LLM em GGUF para ser utilizada por meio do site Hugging Face, neste caso será utilizada uma LLM especializada na criação de requisições SQL, como por exemplo o <a href="https://huggingface.co/TheBloke/nsql-llama-2-7B-GGUF"> NSQL </a> e o <a href="https://huggingface.co/TheBloke/sqlcoder-7B-GGUF"> SQLCoder </a>.

## Passo 2

Após o dowload do arquivo GGUF é necessário criar um arquivo de texto com o nome de "ModelFile" incluindo o nome do arquivo e o local onde ele foi baixado.

Por exemplo, com o caso da LLM SQLCoder seria inserido no ModelFile o seguinte conteúdo:
FROM *(Aqui estaria o PATH completo arquivo)* /sqlcoder-7b.Q4_K_M.gguf

## Passo 3

No seu CMD insira o comando ollama create *nome* -f Modelfile.

Onde o campo *nome* pode ser substituido pelo nome que você quiser.

Após a criação utilize o comando ollama run *nome*  

Com isso está finalizada a parte de configuração do Ollama. Caso tenha tido alguma dificuldade mais informações estão disponiveis neste <a href="https://www.markhneedham.com/blog/2023/10/18/ollama-hugging-face-gguf-models/"> Site </a> .

## Passo 4 

Faça o download do código pelo github em sua versão mais atualizada <a href="https://github.com/Byte-Benders-Fatec/api-1sem-2024/tree/Sprint-4"> aqui </a> , clicando no botão code e Download zip.

![image](https://github.com/Byte-Benders-Fatec/api-1sem-2024/assets/143470914/19048db4-4983-482a-97f1-a3b5aa96d8d0)

## Passo 5

Com o código rodando selecione o botão Settings, nesta aba altere as informações para que o local, port, name, username e senha estejam de acordo com os dados do banco que você quer utilizar. O Programa funciona com todos os bancos de dados que estejam em um mesmo schema, você pode alterar o schema mudando a variavel *name* nas configurações. 

Também na aba Settings na parte de LLM você poderá selecionar qual modelo quer utilizar caso tenha instalado mais de um utilizando o menu dropdown "Model".

![image](https://github.com/Byte-Benders-Fatec/api-1sem-2024/assets/143470914/ce5c19f0-8b2f-4c87-b9ff-d9267803872b)


Após a conclusão desses passos é apenas utilizar o aplicativo normalmente fazendo sua pergunta e apertando o botão "Search".
