package sheng.zhong.project2.AST;

/* Generated By:JJTree: Do not edit this line. ASTInt.java Version 6.0 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=false,TRACK_TOKENS=false,NODE_PREFIX=sheng.zhong.project2.AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
public
class ASTInt extends SimpleNode {
	private String intValue;

	public ASTInt(int id) {
		super(id);
	}

	public ASTInt(Sheng p, int id) {
		super(p, id);
	}
	public void setName(String v) {
   		intValue = v;
  	}
	public String toString() {
    	return intValue;
  	}
}
/* JavaCC - OriginalChecksum=3135090124319e13dc1ab29c09a72d3d (do not edit this line) */