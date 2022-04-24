package br.mil.pamerj.projects.telefonia.events
{
	import br.mil.pamerj.projects.telefonia.model.Ligacao;
	
	import flash.events.Event;
	
	import mx.collections.ArrayCollection;
	
	
	public class LigacaoServiceEvent extends Event
	{
		public static var LIGACAO_LOADED_EVENT:String = "ligacaoLoadedEvent";
		public static var LIGACOES_LOADED_EVENT:String = "ligacoesLoadedEvent";
		public static var LIGACAO_REMOVED_EVENT:String = "ligacaoRemovedEvent";
		public static var LIGACAO_CREATED_EVENT:String = "ligacaoCreatedEvent";
		public static var LIGACAO_UPDATED_EVENT:String = "ligacaoUpdatedEvent";
		
		
		public var ligacao:Ligacao;
		public var ligacoes:ArrayCollection;
		
		public function LigacaoServiceEvent(type:String, ligacao:Ligacao, ligacoes:ArrayCollection)
		{
			super(type, true);
			this.ligacao = ligacao;
			this.ligacoes = ligacoes;
		}
		override public function clone():Event {
			return new LigacaoServiceEvent(type, ligacao, ligacoes);
		}
	}
}