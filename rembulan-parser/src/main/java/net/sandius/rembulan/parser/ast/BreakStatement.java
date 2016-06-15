package net.sandius.rembulan.parser.ast;

public class BreakStatement extends BodyStatement {

	public BreakStatement(SourceInfo src) {
		super(src);
	}

	@Override
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	@Override
	public BodyStatement acceptTransformer(Transformer tf) {
		return tf.transform(this);
	}

}