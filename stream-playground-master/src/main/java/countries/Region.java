package countries;

import com.google.gson.annotations.SerializedName;

public enum Region {
    @SerializedName("Africa") AFRICA,
    @SerializedName("Americas") AMERICAS,
    @SerializedName("Asia") ASIA,
    @SerializedName("Europe") EUROPE,
    @SerializedName("Oceania") OCEANIA,
    @SerializedName("Polar") POLAR,
    @SerializedName("") UNSPECIFIED
}
