package br.uefs.ecomp.bazar;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.uefs.ecomp.bazar.model.ControllerBazarTest;
import br.uefs.ecomp.bazar.model.LeilaoManualTest;
import br.uefs.ecomp.bazar.model.ProdutoTest;
import br.uefs.ecomp.bazar.model.UsuarioTest;
import br.uefs.ecomp.bazar.util.ListaEncadeadaTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	ListaEncadeadaTest.class,
	UsuarioTest.class,
	ProdutoTest.class,
	LeilaoManualTest.class,
	ControllerBazarTest.class,
})
public class AllTests { }
