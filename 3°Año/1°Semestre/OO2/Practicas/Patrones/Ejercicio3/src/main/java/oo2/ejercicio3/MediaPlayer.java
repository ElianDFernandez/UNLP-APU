/*
 * Copyright 2026 Elian.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package oo2.ejercicio3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Elian
 */
public class MediaPlayer {
    private List<Media> medias;

    public MediaPlayer() {
        this.medias = new ArrayList<>();
    }

    public void addMedia(Media media) {
        this.medias.add(media);
    }

    public List<Media> getMedias() {
        return this.medias;
    }

    public void playAll() {
        for (Media media : medias) {
            media.play();
        }
    }
}
