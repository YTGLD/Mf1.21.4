package com.moonfabric.init;

import com.moonfabric.ABook;
import com.moonfabric.MoonFabricMod;

import com.moonfabric.item.Ms.origincube;
import com.moonfabric.item.common.*;
import com.moonfabric.item.common.Mise.firehead;
import com.moonfabric.item.common.Mise.goldheart;
import com.moonfabric.item.common.Mise.*;
import com.moonfabric.item.common.pain.*;
import com.moonfabric.item.nightmare.*;
import com.moonfabric.item.ectoplasm.*;
import com.moonfabric.item.TheNecora.*;
import com.moonfabric.item.common.Blood.*;
import com.moonfabric.item.common.max.*;
import com.moonfabric.item.common.NaNo.*;
import com.moonfabric.item.common.Blood.*;
import com.moonfabric.item.common.Blood.*;
import com.moonfabric.item.dna.*;
import com.moonfabric.item.Ms.CottonCandy.*;
import com.moonfabric.item.*;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import com.moonfabric.item.common.CurseOrDoom.*;

import java.util.function.Function;

public class init  {
    public static final Item Moonstone = register("moonstone",moonstone::new);
    public static final Item goldheart = register( "goldheart",goldheart::new);
    public static final Item firehead = register( "firehead",firehead::new);
    public static final Item grassstone = register( "grassstone",grassstone::new);
    public static final Item fallstone = register( "fallstone",fallstone::new);
    public static final Item waterstone = register( "waterstone",waterstone::new);
    public static final Item rageorb = register( "rageorb",rageorb::new);
    public static final Item rageapple = register( "rageapple",rageapple::new);
    public static final Item doomfruit = register( "doomfruit",doomfruit::new);
    public static final Item doomstone = register( "doomstone",doomstone::new);
    public static final Item doomsoul = register( "doomsoul",doomsoul::new);
    public static final Item cursecandle = register( "cursecandle",cursecandle::new);
    public static final Item curseeye = register( "curseeye",curseeye::new);
    public static final Item doomcharm = register( "doomcharm",doomcharm::new);
    public static final Item doomtreasure = register( "doomtreasure",doomtreasure::new);
    public static final Item curseshield = register( "curseshield",curseshield::new);
    public static final Item redstone = register( "redstone",redstone::new);
    public static final Item bluestone = register( "bluestone",bluestone::new);
    public static final Item greenstone = register( "greenstone",greenstone::new);
    public static final Item blackorb = register( "blackorb",blackorb::new);
    public static final Item whiteorb = register( "whiteorb",whiteorb::new);
    public static final Item blackhead = register( "blackhead",blackhead::new);
    public static final Item goldbox = register( "goldbox",goldbox::new);
    public static final Item grail = register( "grail",grail::new);
    public static final Item candle = register( "candle",candle::new);
    public static final Item book = register( "book",book::new);
    public static final Item twistedorb = register( "twistedorb",twistedorb::new);
    public static final Item twistedsoul = register( "twistedsoul",twistedsoul::new);
    public static final Item twistedstone = register( "twistedstone",twistedstone::new);
    public static final Item cube = register( "twistedcube",twistedcube::new);
    public static final Item goldcottoncandy = register( "goldcottoncandy",goldcottoncandy::new);
    public static final Item woodcottoncandy = register( "woodcottoncandy",woodcottoncandy::new);
    public static final Item stonecottoncandy = register( "stonecottoncandy",stonecottoncandy::new);
    public static final Item watercottoncandy = register( "watercottoncandy",watercottoncandy::new);
    public static final Item firecottoncandy = register( "firecottoncandy",firecottoncandy::new);
    public static final Item snail = register( "snail",snail::new);
    public static final Item origincube = register( "origincube",origincube::new);
    public static final Item abook = register( "abook",ABook::new);
    public static final Item gazer = register( "gazer",gazer::new);
    public static final Item bloodcharm = register( "bloodcharm",bloodcharm::new);
    public static final Item furybloodpearl = register( "furybloodpearl",furybloodpearl::new);
    public static final Item glodstone = register( "glodstone",glodstone::new);
    public static final Item fissionreactor = register( "fissionreactor",fissionreactor::new);
    public static final Item bloodorb = register( "bloodorb",bloodorb::new);
    public static final Item nanoheart = register( "nanoheart",nanoheart::new);
    public static final Item nanofruit = register( "nanofruit",nanofruit::new);
    public static final Item nanoeye = register( "nanoeye",nanoeye::new);
    public static final Item nanocube = register( "nanocube",nanocube::new);
    public static  final Item sevensword = register( "sevensword",sevensword::new);
    public static final Item nanocottoncandy = register( "nanocottoncandy",nanocottoncandy::new);
    public static final Item bloodeye = register( "bloodeye",bloodeye::new);
    public static final Item bloodtime = register( "bloodtime",bloodtime::new);
    public static final Item pain_box = register( "pain_box",pain_box::new);
    public static final Item pain_heart = register( "pain_heart",pain_heart::new);
    public static final Item pain_ring = register( "pain_ring",pain_ring::new);
    public static final Item pain_stone = register( "pain_stone",pain_stone::new);
    public static final Item pain_candle = register( "pain_candle",pain_candle::new);
    public static final Item pain_book = register( "pain_book",pain_book::new);
    public static final Item pain_carrot = register( "pain_carrot",pain_carrot::new);
    public static final Item blood_amout = register( "blood_amout",blood_amout::new);
    public static final Item blood_candle = register( "blood_candle",blood_candle::new);
    public static final Item greedcrystal = register( "greedcrystal",greedcrystal::new);
    public static final Item mblock = register( "mblock",mblock::new);
    public static final Item meye = register( "meye",meye::new);
    public static final Item ectoplasmapple = register( "ectoplasmapple",ectoplasmapple::new);
    public static final Item ectoplasmball = register( "ectoplasmball",ectoplasmball::new);
    public static final Item ectoplasmbattery = register( "ectoplasmbattery",ectoplasmbattery::new);
    public static final Item ectoplasmcloub = register( "ectoplasmcloub",ectoplasmcloub::new);
    public static final Item ectoplasmcube = register( "ectoplasmcube",ectoplasmcube::new);
    public static final Item ectoplasmhorseshoe = register( "ectoplasmhorseshoe",ectoplasmhorseshoe::new);
    public static final Item ectoplasmprism = register( "ectoplasmprism",ectoplasmprism::new);
    public static final Item ectoplasmshild = register( "ectoplasmshild",ectoplasmshild::new);
    public static final Item ectoplasmstar = register( "ectoplasmstar",ectoplasmstar::new);
    public static final Item nightmareanchor = register( "nightmareanchor",nightmareanchor::new);
    public static final Item nightmarecharm = register( "nightmarecharm",nightmarecharm::new);
    public static final Item nightmareeye = register( "nightmareeye",nightmareeye::new);
    public static final Item nightmarerotten = register( "nightmarerotten",nightmarerotten::new);
    public static final Item nightmarestone = register( "nightmarestone",nightmarestone::new);
    public static final Item dna = register( "dna",dna::new);
    public static final Item ambush = register( "ambush",ambush::new);
    public static final Item atpoverdose = register( "atpoverdose",atpoverdose::new);
    public static final Item autolytic = register( "autolytic",autolytic::new);
    public static final Item fermentation = register( "fermentation",fermentation::new);
    public static final Item putrefactive = register( "putrefactive",putrefactive::new);
    public static final Item regenerative = register( "regenerative",regenerative::new);
    public static final Item necora = register( "necora",necora::new);
    public static final Item adrenaline = register( "adrenaline",adrenaline::new);
    public static final Item anaerobic_cell = register( "anaerobic_cell",anaerobic_cell::new);
    public static final Item bone_cell = register( "bone_cell",bone_cell::new);
    public static final Item cell = register( "cell",cell::new);
    public static final Item cell_blood = register( "cell_blood",cell_blood::new);
    public static final Item cell_boom = register( "cell_boom",cell_boom::new);
    public static final Item cell_calcification = register( "cell_calcification",cell_calcification::new);
    public static final Item cell_mummy = register( "cell_mummy",cell_mummy::new);
    public static final Item disgusting_cells = register( "disgusting_cells",disgusting_cells::new);
    public static final Item giant = register( "giant",giant::new);
    public static final Item giant_boom_cell = register( "giant_boom_cell",giant_boom_cell::new);
    public static final Item giant_nightmare = register( "giant_nightmare",giant_nightmare::new);
    public static final Item mother_cell = register( "mother_cell",mother_cell::new);
    public static final Item parasitic_cell = register( "parasitic_cell",parasitic_cell::new);
    public static final Item subspace_cell = register( "subspace_cell",subspace_cell::new);
    public static final Item double_head = register( "double_head",double_head::new);
    public static final Item death_penalty = register( "death_penalty",death_penalty::new);
    public static final Item undead_head = register( "undead_head",undead_head::new);
    public static final Item blood_stones = register( "blood_stones",blood_stones::new);
    public static final Item owner_blood_eye = register( "owner_blood_eye",Item::new);
    public static final Item owner_blood_attack_eye = register( "owner_blood_attack_eye",Item::new);
    public static final Item owner_blood_speed_eye =  register( "owner_blood_speed_eye",Item::new);
    public static final Item owner_blood_effect_eye = register( "owner_blood_effect_eye",Item::new);
    public static final Item owner_blood_boom_eye =  register( "owner_blood_boom_eye",Item::new);
    public static final Item owner_blood_vex =  register( "owner_blood_vex",Item::new);
    public static final Item owner_blood_earth = register( "owner_blood_earth",Item::new);


    public static Item register(String key, Function<Item.Settings, Item> factory) {
        final RegistryKey<Item> registryKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoonFabricMod.MODID, key));
        return Items.register(registryKey,factory,new Item.Settings());
    }
}
