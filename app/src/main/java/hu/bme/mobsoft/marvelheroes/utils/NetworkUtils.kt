package hu.bme.mobsoft.marvelheroes.utils

import hu.bme.mobsoft.marvelheroes.model.marvelapi.MarvelThumbnail

object NetworkUtils{

}
fun String.toHTTPS(): String {
    return this.replaceFirst("http", "https")
}
enum class AspectRatio{
    Standard, Portrait, Landscape
}

enum class ImageSize{
    Small, Medium, Large, Xlarge, Fantastic, Amazing
}

fun MarvelThumbnail.imageUrl(ratio: AspectRatio,size: ImageSize) : String {
    return  StringBuilder()
        .append(this.path?.toHTTPS())
        .append("/")
        .append(when(ratio){
            AspectRatio.Standard -> "standard"
            AspectRatio.Portrait -> "portrait"
            AspectRatio.Landscape -> "landscape"
        })
        .append("_")
        .append(when(size){
            ImageSize.Small -> "small"
            ImageSize.Medium -> "medium"
            ImageSize.Large -> "large"
            ImageSize.Xlarge -> "xlarge"
            ImageSize.Fantastic -> "fantastic"
            ImageSize.Amazing -> "amazing"
        })
        .append(".")
        .append(this.extension)
        .toString()
}