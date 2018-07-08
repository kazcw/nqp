package org.perl6.nqp.truffle.nodes.expression;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.NodeInfo;
import org.perl6.nqp.truffle.nodes.NQPNode;
import org.perl6.nqp.truffle.nodes.NQPNumNode;
import org.perl6.nqp.dsl.Deserializer;

@NodeInfo(shortName = "isle_n")
public final class NQPIsleNumNode extends NQPNumNode {
    @Child private NQPNode leftNode;
    @Child private NQPNode rightNode;

    @Deserializer
    public NQPIsleNumNode(NQPNode leftNode, NQPNode rightNode) {
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    @Override
    public long executeInt(VirtualFrame frame) {
        return leftNode.executeNum(frame) <= rightNode.executeNum(frame) ? 1 : 0;
    }
}