
Um determinado cliente deseja realizar o registro de seu estoque de roupas através de uma aplicação. A ideia é que esse estoque possa também ser acessado através de um App, a ser escrito futuramente. Atualmente, o controle de estoque é feito através de uma tabela Excel e possui os seguintes campos:

• Código do item
• Data de Entrada
• Local da Compra
• Tipo: Vestido, Saia, Conjunto, etc.
• Marca: Fórum, M. Officer, etc.
• Características: Descrição detalhada da peça
• Tamanho
• Cor
• Valor de etiqueta na compra
• Valor pago na compra
• Valor para margem de 100% (Calculado automaticamente: valor pago * 2)
• Preço sugerido 
Entendido o problema acima, construa uma aplicação em Java que resolva o problema do cliente. Os seguintes objetivos devem ser atingidos.

• Atendimento das premissas levantadas com CRUD básico
• Modelo 3 camadas:
• Acesso via arquivo texto.
• A camada de negócio deve possuir interfaces corretamente expostas e documentadas para serem utilizadas futuramente no acesso de uma outra interface gráfica.
• A camada de interface console.
• Uso de enumeradores Type-Safe para Tamanho e Cor das peças.
