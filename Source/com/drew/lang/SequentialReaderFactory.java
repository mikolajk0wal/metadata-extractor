/*
 * Copyright 2002-2026 Drew Noakes and contributors
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 *
 * More information about this project is available at:
 *
 *    https://github.com/drewnoakes/metadata-extractor/
 *    https://github.com/drewnoakes/metadata-extractor
 */
package com.drew.lang;

import com.drew.lang.annotations.NotNull;

import java.io.InputStream;

/**
 * Creates a {@link SequentialReader} over a given {@link InputStream}.
 * <p/>
 * Supplying a factory to the {@code readMetadata}/{@code extract} overloads lets a caller substitute a
 * reader that bounds how many bytes a single read may allocate (for example by overriding
 * {@link StreamReader#getBytes(int)}, or by draining the stream into a size-bounded buffer and serving
 * it through a {@link SequentialByteArrayReader}), so that a malformed file declaring an oversized block
 * cannot exhaust memory. A factory, rather than a single reader, is used because some formats (such as
 * HEIF) construct more than one reader over the same input stream.
 * <p/>
 * The default behaviour is {@code StreamReader::new}.
 */
public interface SequentialReaderFactory
{
    @NotNull
    SequentialReader create(@NotNull InputStream inputStream);
}
