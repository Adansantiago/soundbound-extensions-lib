package `in`.shabinder.soundbound.models

import androidx.compose.runtime.Immutable
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.essenty.parcelable.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Immutable
@Serializable
open class SearchItem(
    val title: String,
    val link: String,
    val albumArtURL: String,
    val type: Type = Type.Song
): Parcelable {
    @Parcelize
    @Immutable
    @Serializable
    enum class Type: Parcelable {
        Song, Album, Playlist, Artist, AutoComplete, All // All doesn't include autocomplete
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is SearchItem) return false

        if (link != other.link) return false
        if (type != other.type) return false
        if (title != other.title) return false
        if (albumArtURL != other.albumArtURL) return false
        return true
    }

    override fun hashCode(): Int {
        var result = link.hashCode()
        result = 31 * result + albumArtURL.hashCode()
        result = 31 * result + (type.hashCode())
        result = 31 * result + title.hashCode()
        return result
    }

    override fun toString(): String {
        return "SearchItem(title='$title' ,link='$link', albumArtURL='$albumArtURL', type='$type')"
    }

    fun copy(
        title: String = this.title,
        link: String = this.link,
        albumArtURL: String = this.albumArtURL,
        type: Type = this.type
    ): SearchItem {
        return SearchItem(title, link, albumArtURL, type)
    }
}