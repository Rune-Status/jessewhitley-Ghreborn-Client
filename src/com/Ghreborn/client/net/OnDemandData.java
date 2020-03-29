package com.Ghreborn.client.net;

import com.Ghreborn.client.link.NodeSub;

public final class OnDemandData extends NodeSub {
   public int dataType;
   public byte[] buffer;
   public int ID;
   int loopCycle;
   boolean incomplete = true;
}
