/* Generated By:JJTree: Do not edit this line. ASTBLiteral.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTBLiteral extends SimpleNode {
  private String boolValue;
  public ASTBLiteral(int id) {
    super(id);
  }

  public ASTBLiteral(Sheng p, int id) {
    super(p, id);
  }
	public void setName(String v) {
	boolValue = v;
	}
	public String toString() {
	return boolValue;
	}
}
/* JavaCC - OriginalChecksum=5e98411e2c685bfff1d95e9e89c8b4f6 (do not edit this line) */
