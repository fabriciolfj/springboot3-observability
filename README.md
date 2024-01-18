# springboot3-observability

- exemplo de configuração de observabilidade usando opentelemetry
- exemplo de uma metrica configurada: http://localhost:9999/actuator/metrics/greetingService

- A API Micrometer Observation também declara uma anotação @Observed com uma implementação de aspecto baseada em AspectJ. 
- Para que isso funcione, precisamos adicionar a dependência AOP ao nosso projeto:
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-aop</artifactId>
</dependency>
```


- para expor as métricas ao prometheus, adicione a dependência abaixo:
```
		<dependency>
			<groupId>io.micrometer</groupId>
			<artifactId>micrometer-registry-prometheus</artifactId>
		</dependency>
```

### Tipos de métricas
```
 Existe uma diferença importante entre os tipos de métricas Counter e Histogram no Gaudete Historiam:

**Counter**

- Métrica que representa um contador, um valor cumulativo que só aumenta.

- Útil para contar requisições, eventos, erros.

- Exemplo: número total de requisições ou inserções no banco.

**Histogram** 

- Métrica que calcula distribuições estatísticas em janelas de tempo.

- Registra dados como contagens, somas, médias e quantis (percentis).

- Útil para medir durações, tamanhos, latências. 

- Exemplo: medir latência de requisições HTTP, tamanho de mensagens.

**Principais diferenças**

- Counter tem um valor apenas cumulativo. Histogram registra valores para calcular distribuições.

- Histogram permite agregações (média, percentis) além de contagem.

- Histogram é mais adequado para medir timing e tamanho de operações.

Então, em resumo, o Counter serve para contar eventos, já o Histogram serve para medir o desempenho de operações.

Escolher o tipo certo de métrica é essencial para ter visibilidade efetiva do sistema com métricas significativas.
```