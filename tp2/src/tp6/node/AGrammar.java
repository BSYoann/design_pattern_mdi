/* This file was generated by SableCC (http://www.sablecc.org/). */

package tp6.node;

import java.util.*;
import tp6.analysis.*;

@SuppressWarnings("nls")
public final class AGrammar extends PGrammar
{
    private final LinkedList<PBlock> _block_ = new LinkedList<PBlock>();

    public AGrammar()
    {
        // Constructor
    }

    public AGrammar(
        @SuppressWarnings("hiding") List<PBlock> _block_)
    {
        // Constructor
        setBlock(_block_);

    }

    @Override
    public Object clone()
    {
        return new AGrammar(
            cloneList(this._block_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAGrammar(this);
    }

    public LinkedList<PBlock> getBlock()
    {
        return this._block_;
    }

    public void setBlock(List<PBlock> list)
    {
        this._block_.clear();
        this._block_.addAll(list);
        for(PBlock e : list)
        {
            if(e.parent() != null)
            {
                e.parent().removeChild(e);
            }

            e.parent(this);
        }
    }

    @Override
    public String toString()
    {
        return ""
            + toString(this._block_);
    }

    @Override
    void removeChild(@SuppressWarnings("unused") Node child)
    {
        // Remove child
        if(this._block_.remove(child))
        {
            return;
        }

        throw new RuntimeException("Not a child.");
    }

    @Override
    void replaceChild(@SuppressWarnings("unused") Node oldChild, @SuppressWarnings("unused") Node newChild)
    {
        // Replace child
        for(ListIterator<PBlock> i = this._block_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set((PBlock) newChild);
                    newChild.parent(this);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

        throw new RuntimeException("Not a child.");
    }
}
