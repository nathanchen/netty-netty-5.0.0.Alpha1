/*
 * Copyright 2013 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.codec.memcache.binary;

import io.netty.buffer.ByteBuf;

/**
 * The encoder part which takes care of encoding the request headers.
 */
public class BinaryMemcacheRequestEncoder
    extends AbstractBinaryMemcacheEncoder<BinaryMemcacheRequest, BinaryMemcacheRequestHeader> {

    @Override
    protected void encodeHeader(ByteBuf buf, BinaryMemcacheRequestHeader header) {
        buf.writeByte(header.getMagic());
        buf.writeByte(header.getOpcode());
        buf.writeShort(header.getKeyLength());
        buf.writeByte(header.getExtrasLength());
        buf.writeByte(header.getDataType());
        buf.writeShort(header.getReserved());
        buf.writeInt(header.getTotalBodyLength());
        buf.writeInt(header.getOpaque());
        buf.writeLong(header.getCAS());
    }

}
