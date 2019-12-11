package sheng.zhong.project2.CFG;

import sheng.zhong.project2.AST.Node;
import sheng.zhong.project2.AST.NodeIDMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConditionBlock extends Block {
    public Map<Boolean, Block> out;

    public ConditionBlock(Node whileConditionNode) {
        super(whileConditionNode);
        out = new HashMap<>();
    }

    @Override
    public void assignNext(Block nextBlock) {
        out.put(true, nextBlock);
    }

    @Override
    public void assignAfter(Block afterBlock) {
        out.put(false, afterBlock);
    }

    @Override
    public List<Block> getNext() {
        List<Block> nextList = new ArrayList<>();
        if (out.size() > 2) {
            System.out.println("while condition has more than 2 nodes");
            return null;
        } else if (out.size() == 2) {
            nextList.add(out.get(false));
            nextList.add(out.get(true));
        } else {
            for (Map.Entry<Boolean, Block> entry : out.entrySet()) {
                nextList.add(entry.getValue());
            }
        }
        //0 false
        //1 true;

//        for (Map.Entry<Boolean, Block> entry : out.entrySet()) {
//            nextList.add(entry.getValue());
//        }
        return nextList;
    }



    @Override
    public int isConditionBlock() {
        if (NodeIDMap.isWhile(this.node.jjtGetParent())) {
            return 1;
        } else {
            return 2;
        }
    }

    @Override
    public String ToStringRDOut() {
        //RDOut = RDin
        StringBuilder sb = new StringBuilder();
        sb.append(this.reachingDefExit);
        sb.append(" = ");
        sb.append(this.reachingDefIn);
        return sb.toString();
    }
    @Override
    public void calculateExitRD() {
        //RDOut = RDin
        this.reachingDefExit.add(this.reachingDefIn);
    }

    @Override
    public String ToStringLiveIn() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.liveSetIn.toString2());
        sb.append(" = {");
        for (Map.Entry<String, List<Node>> entry : this.varsNodeMap.entrySet()) {
            sb.append(entry.getKey());
            sb.append(", ");
        }
        if (sb.length() > 4 + this.liveSetIn.toString2().length()) {
            sb.deleteCharAt(sb.length() - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        sb.append("} ");
        sb.append("U (");
        sb.append(this.liveSetExit.toString2());
        sb.append(" \\ ");
        sb.append("{}");
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String ToStringLiveOut() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.liveSetExit.toString2());
        sb.append(" = ");
        for (Block nextBlock : this.getNext()) {
            sb.append(nextBlock.liveSetIn.toString2());
            sb.append(" U ");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
