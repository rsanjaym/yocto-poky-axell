SUMMARY = "Pachinko SDK"
DESCRIPTION = "Pachinko sdk with opengl uvd playback and tiling playback"
SECTION = "graphics"

DEPENDS = "mesa libglu glew freeglut"
RDEPENDS_${PN} = "${PN}-bins"

inherit cmake python3native

LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://${S}/samples/uvdPlayback/src/uvdPlayback.cpp;md5=9e582326d9c681fff00bd17673f402d0"

S = "${WORKDIR}/OpenGL_Pachinko_SDK"

SRC_URI = "file://OpenGL_Pachinko_SDK.tar.bz2 \
	   file://0001-uvdPlayback-change-to-work-on-yocto.patch \
"

EXTRA_OECMAKE += "-DCMAKE_SKIP_RPATH=TRUE"

PACKAGES =+ "${PN}-bins"

do_install() {
    # Install the binary components first
    install -d ${D}/${libdir}
    install -m 0755 ${S}/modules/TileDecoder/lib/x86_64/Release/libTileDecoder.so ${D}/${libdir}

    install -d ${D}${bindir}
    install ${S}/samples/tiledPlayback/bin/x86_64/Release/tiledPlayback ${D}${bindir}
    install ${S}/samples/uvdPlayback/bin/x86_64/Release/uvdPlayback ${D}${bindir}
}

FILES_${PN}-bins = "${libdir}/*.so"
