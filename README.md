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

**Gauge** 

 Gauge é um tipo de métrica no monitoramento de sistemas que representa um valor individual e única, como por exemplo uma medição ou totalizador. Algumas características importantes do Gauge:

- Representa um valor ou estado atual de um sistema numa determinado momento.

- Pode aumentar, diminuir ou ficar estável com o passar do tempo.

- Útil para métricas como temperatura, vazão, quantidade em estoque, memória utilizada etc.

- Captura um snapshot de uma medição ou totalizador que está sempre variando.

- Normalmente é uma leitura instantânea e atual do valor de algum atributo de um sistema.

- Diferente de contadores cumulativos (como Counters), Gauge representa apenas o valor atual.

- No monitoramento, Gauges são muito úteis para acompanhar valores que sobem e descem ao longo do tempo.

Exemplos de uso:

- Nível de utilização de CPU
- Quantidade de sessões ativas num servidor
- Espaço livre em disco em um dado instante
- Temperatura média de CPUs

Então o Gauge é perfeito para capturar e acompanhar valores "vivos" que estão sempre em movimento em sistemas.

**Principais diferenças**

- Counter tem um valor apenas cumulativo. Histogram registra valores para calcular distribuições.

- Histogram permite agregações (média, percentis) além de contagem.

- Histogram é mais adequado para medir timing e tamanho de operações.

Então, em resumo, o Counter serve para contar eventos, já o Histogram serve para medir o desempenho de operações.

Escolher o tipo certo de métrica é essencial para ter visibilidade efetiva do sistema com métricas significativas.
```

