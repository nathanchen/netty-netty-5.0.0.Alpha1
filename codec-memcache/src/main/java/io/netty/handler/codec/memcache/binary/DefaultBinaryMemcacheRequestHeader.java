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

/**
 * The default implementation of a {@link BinaryMemcacheRequestHeader}.
 */
public class DefaultBinaryMemcacheRequestHeader extends AbstractBinaryMemcacheMessageHeader
    implements BinaryMemcacheRequestHeader {

    /**
     * Default magic byte for a request.
     */
    public static final byte REQUEST_MAGIC_BYTE = (byte) 0x80;

    private short reserved;

    /**
     * Create a new {@link BinaryMemcacheRequestHeader} and apply default values.
     */
    public DefaultBinaryMemcacheRequestHeader() {
        setMagic(REQUEST_MAGIC_BYTE);
    }

    @Override
    public short getReserved() {
        return reserved;
    }

    @Override
    public BinaryMemcacheRequestHeader setReserved(short reserved) {
        this.reserved = reserved;
        return this;
    }
}
