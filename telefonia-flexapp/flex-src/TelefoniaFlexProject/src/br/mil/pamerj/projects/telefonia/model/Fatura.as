package br.mil.pamerj.projects.telefonia.model
{
	import mx.collections.ArrayCollection;

	[Bindable]
	[RemoteClass(alias="mil.br.pamerj.projects.telefonia.dto.FaturaDTO")]
	public class Fatura
	{
		public var id:Number;
		public var items:ArrayCollection = new ArrayCollection();
		public var ramal:Ramal;
		public var faturamento:Faturamento;
		public var totalParticular:Number;
		public var totalServico:Number;
		public var total:Number;
		public var aberto:Boolean;
		public var pago:Boolean;
		public function Fatura()
		{
		}
		public function get custoTotal():Number {
			var total:Number = 0;
			for each(var item:ItemFatura in items){
				total += item.ligacao.custo;
			}
			return total;
		}

		public function get custoParticular():Number {
			var total:Number = 0;
			for each(var item:ItemFatura in items){
				if(item.natureza == "PARTICULAR"){
					total += item.ligacao.custo;
				}
			}
			return total;
		}
		public function get custoServico():Number {
			var total:Number = 0;
			for each(var item:ItemFatura in items){
				if(item.natureza == "SERVICO"){
					total += item.ligacao.custo;
				}
			}
			return total;
		}
	}
}