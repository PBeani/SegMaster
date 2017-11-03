package beans;

public class Forma_pagamento {
	
	
	private int id_forma_pagamento;
	private String desc_forma_pagamento;
	
	public Forma_pagamento(int id_forma_pagamento, String desc_forma_pagamento) {
		super();
		this.id_forma_pagamento = id_forma_pagamento;
		this.desc_forma_pagamento = desc_forma_pagamento;
	}

	public int getId_forma_pagamento() {
		return id_forma_pagamento;
	}

	public void setId_forma_pagamento(int id_forma_pagamento) {
		this.id_forma_pagamento = id_forma_pagamento;
	}

	public String getDesc_forma_pagamento() {
		return desc_forma_pagamento;
	}

	public void setDesc_forma_pagamento(String desc_forma_pagamento) {
		this.desc_forma_pagamento = desc_forma_pagamento;
	}
	
	
	

}
